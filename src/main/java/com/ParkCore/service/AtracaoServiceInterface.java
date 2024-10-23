package com.ParkCore.service;

import com.ParkCore.enums.AtracaoTipo;
import com.ParkCore.model.Atracao;

import java.util.List;

public interface AtracaoServiceInterface {

    Atracao createAtracao(Atracao atracao);

    List<Atracao> listaAtracoes();

    List<Atracao> buscarPorTipo(AtracaoTipo tipo);

    void deleteAtracao(Long id);
}
