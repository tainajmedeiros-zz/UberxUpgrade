package br.com.Uberx.service;

import br.com.Uberx.entity.Passageiro;
import br.com.Uberx.entity.Viagem;
import br.com.Uberx.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    //Adicionar um passageiro
    public Passageiro adicionarPassageiro(Passageiro passageiro){
        return passageiroRepository.save(passageiro);
    }

    //Buscar um passageiro por cpf
    public Passageiro buscarPassageiroPorCpf(String cpf){
        return passageiroRepository.findByCpf(cpf);
    }

//    //Listar viagens de um passageiro por cpf
//    public List<Viagem> listarViagensPorCpf(String cpf){
//
//    }
//
//    //Apagar uma viagem do histórico de um passageiro
//    public Viagem apagarViagemDoHistorico(long id_viagem, String cpf){
//
//    }

    //Atualizar lista de viagem de passageiro
    public Passageiro atualizarListaViagem(Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }
}
