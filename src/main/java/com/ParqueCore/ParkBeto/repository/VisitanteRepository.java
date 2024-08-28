package com.ParqueCore.ParkBeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ParqueCore.ParkBeto.model.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long>{

}
