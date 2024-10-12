package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
import com.ParqueCore.ParkBeto.model.Atracao;

import java.util.List;

public interface AtracaoServiceInterface {

    Atracao createAtracao(Atracao atracao);

    List<Atracao> listaAtracoes();

    List<Atracao> buscarPorTipo(AtracaoTipo tipo);

    void deleteAtracao(Long id);
}
