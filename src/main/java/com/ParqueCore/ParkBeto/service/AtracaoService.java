package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtracaoService {

    @Autowired
    private AtracaoRepository atracaoRepository;

    public Atracao save(Atracao atracao) {
        return atracaoRepository.save(atracao);
    }

}
