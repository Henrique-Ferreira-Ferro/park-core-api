package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.model.Visitante;

public interface VisitanteServiceInterface {

    Visitante cadastrarVisitante(Visitante visitante);
    void excluirVisitante(Long visitanteId);
}
