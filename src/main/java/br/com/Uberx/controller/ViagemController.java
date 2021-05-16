package br.com.Uberx.controller;

import br.com.Uberx.entity.Viagem;
import br.com.Uberx.service.ViagemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uberx")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @ApiOperation(value = "Add a new travel")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered travel", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PostMapping("/viagem")
    public ResponseEntity<?> addViagem(@RequestBody Viagem viagem){
        try {
            return new ResponseEntity<>(viagemService.adicionarViagem(viagem), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new br.com.Uberx.payload.Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);        }
    }

    @ApiOperation(value = "Finds the all travels")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the list travel", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "List travel not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/viagens")
    public ResponseEntity<?> listarViagens(){
        try {
            List<Viagem> viagens = viagemService.listarViagens();
            if(viagens == null){
                return new ResponseEntity<>(
                        new br.com.Uberx.payload.Response(false, "Nenhum viagem encontrada!"),
                        HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(viagens, HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(
                    new br.com.Uberx.payload.Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
