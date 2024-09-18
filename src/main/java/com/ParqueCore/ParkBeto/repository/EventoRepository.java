package com.ParqueCore.ParkBeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ParqueCore.ParkBeto.model.Evento;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
    List<Evento> findByAtracaoId(Long atracaoId);

}
