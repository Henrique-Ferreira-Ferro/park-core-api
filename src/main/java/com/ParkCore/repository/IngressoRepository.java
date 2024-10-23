package com.ParkCore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ParkCore.model.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long>{

}
