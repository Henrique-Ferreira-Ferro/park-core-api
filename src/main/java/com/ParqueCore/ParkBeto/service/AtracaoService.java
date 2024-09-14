package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtracaoService {

    @Autowired
    private AtracaoRepository atracaoRepository;

    @Autowired
    private EventoRepository eventoRepository;


    private boolean isNomeUnique(String nome) {

        return !atracaoRepository.existsByName(nome);
    }

    @Transactional
    public Atracao createAtracao(Atracao atracao){
        if(isNomeUnique(atracao.getNome())){
            return atracaoRepository.save(atracao);
        }else{
            throw new IllegalArgumentException("A atracao ja foi cadastrada");
        }
    }



    public void deleteAtracao(Long id){
        Atracao atracao = atracaoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Usuario nao encontrado"));

        List<Evento> eventos = eventoRepository.findByAtracaoId(id);
        if (!eventos.isEmpty()) {
            throw new IllegalStateException("Atracao nao pode ser deletada pois esta associada a um evento!");
        }
        atracaoRepository.delete(atracao);

    }

}
