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
        // Verifica se a atração existe
        var atracao = atracaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atração não encontrada"));

        // Verifica se existem eventos associados à atração
        var eventos = eventoRepository.findByAtracaoId(id);
        if (!eventos.isEmpty()) {
            throw new BadRequestException("Atração não pode ser deletada, pois está associada a um evento!");
        }

        // Se as verificações passarem, deleta a atração
        atracaoRepository.delete(atracao);
    }
}
