package br.com.Uberx.entity.DTO;

import br.com.Uberx.entity.Passageiro;
import br.com.Uberx.entity.Viagem;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class PassageiroDTO {

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String cpf;

    @OneToMany
    private List<Viagem> viagemList;

    public PassageiroDTO(Passageiro passageiro){
        this.nome = passageiro.getNome();
        this.cpf = passageiro.getCpf();
        this.viagemList = passageiro.getViagemList();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Viagem> getViagemList() {
        return viagemList;
    }


    public static PassageiroDTO converter(Passageiro passageiro){
        return new PassageiroDTO(passageiro);
    }
}
