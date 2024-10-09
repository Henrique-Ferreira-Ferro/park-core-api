package com.ParqueCore.ParkBeto.service.impl;

import static com.ParqueCore.ParkBeto.validation.VisitanteValidator.validateCpfVisitante;
import static com.ParqueCore.ParkBeto.validation.VisitanteValidator.validateTelefoneVisitante;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;
import com.ParqueCore.ParkBeto.service.VisitanteServiceInterface;

import jakarta.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class VisitanteService implements VisitanteServiceInterface {


	private VisitanteRepository visitanteRepository;

    
    public Visitante cadastrarVisitante(Visitante visitante) {

        validateTelefoneVisitante(visitante);
        validateCpfVisitante(visitante);
    	
    	return visitanteRepository.save(visitante);
    }



	public void excluirVisitante(Long visitanteId) {
        var visitante = visitanteRepository.findById(visitanteId)
                .orElseThrow(() -> new EntityNotFoundException("Visitante não encontrado"));

        if (visitanteRepository.hasIngressos(visitanteId)) {
            throw new BadRequestException("Não é possível remover o visitante com ingressos comprados");
        }

        if (visitanteRepository.hasFeedbacksPendentes(visitanteId)) {
            throw new BadRequestException("Não é possível remover o visitante com avaliações pendentes");
        }

        visitanteRepository.delete(visitante);
    }
    
	
	

	

	
}
