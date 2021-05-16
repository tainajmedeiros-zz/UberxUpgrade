package br.com.Uberx.repository;

import br.com.Uberx.entity.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
    Passageiro findByCpf(String cpf);
}
