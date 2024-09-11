package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtracaoService {

    @Autowired
    private AtracaoRepository atracaoRepository;

    @Transactional
    public Atracao createAtracao(Atracao atracao){
        if(isNomeUnique(atracao.getNome())){
            return atracaoRepository.save(atracao);
        }else{
            throw new IllegalArgumentException("A atracao ja foi cadastrada");
        }
    }

    private boolean isNomeUnique(String nome) {
        return !atracaoRepository.existsByName(nome);
    }


    public void deleteAtracao(Long id){
        Atracao atracao = atracaoRepository.findById(id).orElseThrow();
        atracaoRepository.delete(atracao);

    }


}
