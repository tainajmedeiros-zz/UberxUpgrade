package br.com.Uberx.service;

import br.com.Uberx.entity.Cartao;
import br.com.Uberx.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    //Adicionar Cartão
    public Cartao adicionarCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    //Buscar cartão pela agencia e conta
    public Cartao buscarCartaoPorAgenciaConta(int agencia, int conta){
        return cartaoRepository.findByAgenciaAndConta(agencia, conta);
    }
}
