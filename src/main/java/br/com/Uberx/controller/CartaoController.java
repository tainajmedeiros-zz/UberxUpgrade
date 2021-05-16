package br.com.Uberx.controller;

import br.com.Uberx.entity.Cartao;
import br.com.Uberx.entity.DTO.CartaoDTO;
import br.com.Uberx.payload.Response;
import br.com.Uberx.service.CartaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uberx")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @ApiOperation(value = "Add a new card")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered card", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PostMapping("/cartao")
    public ResponseEntity<?> addCartao(@RequestBody Cartao cartao){
        try {
            return new ResponseEntity<>(cartaoService.adicionarCartao(cartao), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(
                    new Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);        }
    }

    @ApiOperation(value = "Find a card whit agencia and conta numbers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the card", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "Card not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/cartao/{agencia}/{conta}")
    public ResponseEntity<?> buscarCartao(@PathVariable int agencia, @PathVariable int conta){
        try{
            Cartao cartao = cartaoService.buscarCartaoPorAgenciaConta(agencia,conta);
            if(cartao == null){
                return new ResponseEntity<>(
                        new Response(false, "Cartão não encontrado com agencia: " + agencia + " conta: " + conta),
                        HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(CartaoDTO.converter(cartao), HttpStatus.FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(
                    new Response(false, "Erro na requisição!"),
                    HttpStatus.BAD_REQUEST);
        }

    }
}
