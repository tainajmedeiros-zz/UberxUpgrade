package br.com.Uberx.repository;

import br.com.Uberx.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Cartao findByAgenciaAndConta(int agencia, int conta);
}
