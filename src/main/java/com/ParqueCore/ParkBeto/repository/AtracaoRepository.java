package com.ParqueCore.ParkBeto.repository;

import com.ParqueCore.ParkBeto.model.Atracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtracaoRepository extends JpaRepository<Atracao, Long>{
    boolean existsByNome(String nome);


    Optional<Atracao> findByNome(String nome);
}
