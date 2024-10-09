package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;
import com.ParqueCore.ParkBeto.service.VisitanteServiceInterface;
import org.springframework.stereotype.Service;

import static com.ParqueCore.ParkBeto.validation.VisitanteValidator.validateCpfVisitante;
import static com.ParqueCore.ParkBeto.validation.VisitanteValidator.validateTelefoneVisitante;

@Service
public class VisitanteService implements VisitanteServiceInterface {

    private final VisitanteRepository visitanteRepository;

    public VisitanteService(VisitanteRepository visitanteRepository) {
        this.visitanteRepository = visitanteRepository;
    }

    public Visitante cadastrarVisitante(Visitante visitante) {
        validateCpfVisitante(visitante);
        validateTelefoneVisitante(visitante);
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
