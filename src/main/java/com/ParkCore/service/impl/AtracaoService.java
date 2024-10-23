package com.ParkCore.service.impl;

import com.ParkCore.service.AtracaoServiceInterface;
import com.ParkCore.enums.AtracaoTipo;
import com.ParkCore.exceptions.BadRequestException;
import com.ParkCore.exceptions.NoContentException;
import com.ParkCore.model.Atracao;
import com.ParkCore.repository.AtracaoRepository;
import com.ParkCore.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtracaoService implements AtracaoServiceInterface {

    private final AtracaoRepository atracaoRepository;
    private final EventoRepository eventoRepository;

    public AtracaoService(AtracaoRepository atracaoRepository, EventoRepository eventoRepository) {
        this.atracaoRepository = atracaoRepository;
        this.eventoRepository = eventoRepository;
    }

    private boolean isNomeUnique(String nome) {
        return !atracaoRepository.existsByNome(nome);
    }

    private boolean hasAssociatedEvents(Long id) {
        return !eventoRepository.findByAtracaoId(id).isEmpty();
    }

    public Atracao createAtracao(Atracao atracao) {
        if (!isNomeUnique(atracao.getNome())) {
            throw new BadRequestException("Erro ao criar atração: A atração com o nome '" + atracao.getNome() + "' já existe no sistema.");
        }

        return atracaoRepository.save(atracao);
    }

    public List<Atracao> listaAtracoes() {
        return atracaoRepository.findAll();
    }


    public List<Atracao> buscarPorTipo(AtracaoTipo tipo) {
        var atracoes = atracaoRepository.findByTipo(tipo);
        if (atracoes.isEmpty()) {
            throw new NoContentException("Nenhuma atração do tipo '" + tipo + "' foi encontrada no sistema.");
        }
        return atracoes;
    }

    @Transactional
    public void deleteAtracao(Long id) {
        var atracao = atracaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao buscar atração: Atração com ID " + id + " não foi encontrada."));

        if (hasAssociatedEvents(id)) {
            throw new BadRequestException("Erro ao deletar atração: Atração com ID " + id + " não pode ser deletada, pois está associada a um ou mais eventos.");
        }
        atracaoRepository.delete(atracao);
    }
}