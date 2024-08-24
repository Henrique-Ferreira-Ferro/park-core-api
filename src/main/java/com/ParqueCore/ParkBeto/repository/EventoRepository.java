package com.ParqueCore.ParkBeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ParqueCore.ParkBeto.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
