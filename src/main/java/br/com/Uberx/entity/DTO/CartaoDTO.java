package br.com.Uberx.entity.DTO;

import br.com.Uberx.entity.Cartao;
import com.sun.istack.NotNull;

import javax.persistence.Column;

public class CartaoDTO {

    @Column
    @NotNull
    private int agencia;

    @Column
    @NotNull
    private int conta;

    private CartaoDTO(Cartao cartao){
        this.agencia = cartao.getAgencia();
        this.conta = cartao.getConta();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public static CartaoDTO converter(Cartao cartao){
        return new CartaoDTO(cartao);
    }
}
