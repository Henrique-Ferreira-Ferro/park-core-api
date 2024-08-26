package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtracaoService {

    @Autowired
    private AtracaoRepository atracaoRepository;

    public void saveAtracao(Atracao atracao){
        this.atracaoRepository.save(atracao);
    }
    public Atracao createAtracao(Atracao atracao){
        this.saveAtracao(atracao);
        return atracao;
    }

}
