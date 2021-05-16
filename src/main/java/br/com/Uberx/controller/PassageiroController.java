package br.com.Uberx.controller;

import br.com.Uberx.entity.DTO.PassageiroDTO;
import br.com.Uberx.entity.Passageiro;
import br.com.Uberx.entity.Viagem;
import br.com.Uberx.service.PassageiroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/uberx")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    private PassageiroDTO passageiroDTO;

    @ApiOperation(value = "Add a new Passenger")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered Passenger", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PostMapping("/passageiro")
    public ResponseEntity<?> addPassageiro(@RequestBody Passageiro passageiro){
        try {
            return new ResponseEntity<>(passageiroService.adicionarPassageiro(passageiro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new br.com.Uberx.payload.Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);           }
    }

    @ApiOperation(value = "Find a passenger by cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the passenger", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "Passenger not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/passageiro/{cpf}")
    public ResponseEntity<?> buscarPassageiro(@PathVariable String cpf){
        try {
            Passageiro passageiro = passageiroService.buscarPassageiroPorCpf(cpf);
            if(passageiro == null) {
                return new ResponseEntity<>(
                        new br.com.Uberx.payload.Response(false, "Passageiro não encontrado com esse cpf: " + cpf),
                        HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(PassageiroDTO.converter(passageiro), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new br.com.Uberx.payload.Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);           }
    }

    @ApiOperation(value = "Find a list travel of passenger by cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the list travel", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "Passenger not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/passageiro/viagens/{cpf}")
    public ResponseEntity<?> listarViagens(@PathVariable String cpf){
        try {
            Passageiro passageiro = passageiroService.buscarPassageiroPorCpf(cpf);
            if (passageiro == null) {
                return new ResponseEntity<>(
                        new br.com.Uberx.payload.Response(false, "Passageiro não encontrado com esse cpf: " + cpf),
                        HttpStatus.NOT_FOUND);
            } else {
                List<Viagem> listaDeViagemDoPassageiro = passageiro.getViagemList();
                return new ResponseEntity<>(listaDeViagemDoPassageiro, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new br.com.Uberx.payload.Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);           }
    }

    @ApiOperation(value = "Delete a travel of passenger list by cpf and id travel")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the passenger whit new list travel", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "Passenger not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PutMapping("/passageiro/{id_viagem}/{cpf}")
    public ResponseEntity<?> apagarViagem(@PathVariable long id_viagem, @PathVariable String cpf){
        try {
            Passageiro passageiro = passageiroService.buscarPassageiroPorCpf(cpf);
            if (passageiro == null) {
                return new ResponseEntity<>(
                        new br.com.Uberx.payload.Response(false, "Passageiro não encontrado com esse cpf: " + cpf),
                        HttpStatus.NOT_FOUND);
            } else {
                List<Viagem> listaDeViagemDoPassageiro = passageiro.getViagemList();
                for(Viagem viagem: listaDeViagemDoPassageiro) {
                    if(viagem.getId().equals(id_viagem)){
                        listaDeViagemDoPassageiro.remove(viagem);
                        passageiro.setViagemList(listaDeViagemDoPassageiro);
                        Passageiro passageiroComListaNova = passageiroService.atualizarListaViagem(passageiro);
                        return new ResponseEntity<>(passageiroComListaNova, HttpStatus.OK);
                    }
                }
                return new ResponseEntity<>(
                        new br.com.Uberx.payload.Response(false, "Viagem não encontrado com id: " + id_viagem),
                        HttpStatus.NOT_FOUND);             }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new br.com.Uberx.payload.Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
