package com.ParqueCore.ParkBeto.repository;

import com.ParqueCore.ParkBeto.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

    @Query("SELECT COUNT(i) > 0 FROM Ingresso i WHERE i.visitante.id = :visitanteId")
    boolean hasIngressos(@Param("visitanteId") Long visitanteId);

    @Query("SELECT COUNT(f) > 0 FROM Feedback f WHERE f.visitante.id = :visitanteId")
    boolean hasFeedbacksPendentes(@Param("visitanteId") Long visitanteId);

    boolean existsByCpf(String cpf);
}
