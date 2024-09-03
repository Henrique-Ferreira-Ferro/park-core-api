package com.ParqueCore.ParkBeto.repository;

import com.ParqueCore.ParkBeto.model.Atracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtracaoRepository extends JpaRepository<Atracao, Long>{
    boolean existsByName(String nome);
}
