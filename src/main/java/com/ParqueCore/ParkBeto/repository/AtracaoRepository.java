package com.ParqueCore.ParkBeto.repository;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtracaoRepository extends JpaRepository<Atracao, Long>{
    boolean existsByNome(String nome);


    List<Atracao> findByTipo(AtracaoTipo tipo);
}
