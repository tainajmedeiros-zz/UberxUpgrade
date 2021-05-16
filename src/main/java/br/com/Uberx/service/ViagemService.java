package br.com.Uberx.service;

import br.com.Uberx.entity.Viagem;
import br.com.Uberx.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    //Adicionar viagem
    public Viagem adicionarViagem(Viagem viagem){
        return viagemRepository.save(viagem);
    }


    //Buscar todas as viagem
    public List<Viagem> listarViagens(){
        return viagemRepository.findAll();
    }
}
