package com.ParkCore.service.impl;

import com.ParkCore.repository.VisitanteRepository;
import com.ParkCore.service.VisitanteServiceInterface;
import com.ParkCore.validation.VisitanteValidator;
import com.ParkCore.exceptions.BadRequestException;
import com.ParkCore.model.Visitante;
import org.springframework.stereotype.Service;

@Service
public class VisitanteService implements VisitanteServiceInterface {

    private final VisitanteRepository visitanteRepository;

    public VisitanteService(VisitanteRepository visitanteRepository) {
        this.visitanteRepository = visitanteRepository;
    }

    public Visitante cadastrarVisitante(Visitante visitante) {
        VisitanteValidator.validateCpfVisitante(visitante);
        VisitanteValidator.validateTelefoneVisitante(visitante);
        return visitanteRepository.save(visitante);
    }

    public void excluirVisitante(Long visitanteId) {
        var visitante = visitanteRepository.findById(visitanteId)
                .orElseThrow(() -> new BadRequestException("Visitante não encontrado"));

        verificarExclusao(visitanteId);

        visitanteRepository.delete(visitante);
    }

    private void verificarExclusao(Long visitanteId) {
        if (visitanteRepository.hasIngressos(visitanteId)) {
            throw new BadRequestException("Não é possível remover o visitante com ingressos comprados");
        }

        if (visitanteRepository.hasFeedbacksPendentes(visitanteId)) {
            throw new BadRequestException("Não é possível remover o visitante com avaliações pendentes");
        }
    }
}
