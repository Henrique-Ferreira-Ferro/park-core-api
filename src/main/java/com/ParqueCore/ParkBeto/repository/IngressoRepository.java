package com.ParqueCore.ParkBeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ParqueCore.ParkBeto.model.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long>{

}
