package com.ParkCore.repository;

import com.ParkCore.enums.AtracaoTipo;
import com.ParkCore.model.Atracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtracaoRepository extends JpaRepository<Atracao, Long>{
    boolean existsByNome(String nome);


    List<Atracao> findByTipo(AtracaoTipo tipo);
}
