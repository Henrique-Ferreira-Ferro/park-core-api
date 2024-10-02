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

    private boolean hasAssociatedEvents(Long atracaoId) {
        return !eventoRepository.findByAtracaoId(atracaoId).isEmpty();
    }


    public Atracao createAtracao(Atracao atracao) {
        if (isNomeUnique(atracao.getNome())) {
            return atracaoRepository.save(atracao);
        } else {
            throw new BadRequestException("A atração com o nome '" + atracao.getNome() + "' já foi cadastrada.");
        }
    }


    public void deleteAtracao(Long id) {
        var atracao = atracaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atração com ID " + id + " não foi encontrada."));

        if (hasAssociatedEvents(id)) {
            throw new BadRequestException("A atração não pode ser deletada pois está associada a um ou mais eventos.");
        }

        atracaoRepository.delete(atracao);
    }
}
