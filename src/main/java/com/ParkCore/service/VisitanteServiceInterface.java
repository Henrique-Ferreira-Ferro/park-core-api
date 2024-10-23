package com.ParkCore.service;

import com.ParkCore.model.Visitante;

public interface VisitanteServiceInterface {

    Visitante cadastrarVisitante(Visitante visitante);
    void excluirVisitante(Long visitanteId);
}
