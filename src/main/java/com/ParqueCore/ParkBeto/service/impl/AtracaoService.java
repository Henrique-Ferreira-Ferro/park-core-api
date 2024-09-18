package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtracaoService {

    @Autowired
    private AtracaoRepository atracaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    private boolean isNomeUnique(String nome) {

        return !atracaoRepository.existsByNome(nome);
    }

    public Atracao createAtracao(Atracao atracao) {
        if (isNomeUnique(atracao.getNome())) {
            return atracaoRepository.save(atracao);
        } else {
            throw new BadRequestException("A atracao ja foi cadastrada");
        }
    }

    public void deleteAtracao(Long id) {
        var atracao = atracaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
        var eventos = eventoRepository.findByAtracaoId(id);
        if (!eventos.isEmpty()) {
            throw new BadRequestException("Atracao nao pode ser deletada pois esta associada a um evento!");
        }
        atracaoRepository.delete(atracao);
    }
}
