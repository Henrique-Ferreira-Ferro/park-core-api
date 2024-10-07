package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.ParqueCore.ParkBeto.exceptions.NoContentException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtracaoService {

    private final AtracaoRepository atracaoRepository;
    private final EventoRepository eventoRepository;

    // Injeção de dependência via construtor
    public AtracaoService(AtracaoRepository atracaoRepository, EventoRepository eventoRepository) {
        this.atracaoRepository = atracaoRepository;
        this.eventoRepository = eventoRepository;
    }

    private boolean isNomeUnique(String nome) {
        return !atracaoRepository.existsByNome(nome);
    }

    public Atracao createAtracao(Atracao atracao) {
        if (!isNomeUnique(atracao.getNome())) {
            throw new BadRequestException("Atração com o nome '" + atracao.getNome() + "' já existe.");
        }
        return atracaoRepository.save(atracao);
    }

    public List<Atracao> listaAtracoes() {
        return atracaoRepository.findAll();
    }

    public Atracao buscarPorId(long id) {
        return atracaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atracao nao encontrada"));
    }

    public List<Atracao> buscarPorTipo(AtracaoTipo tipo) {
        List<Atracao> atracoes = atracaoRepository.findByTipo(tipo);
        // Se a lista estiver vazia, lança a exceção customizada
        if (atracoes.isEmpty()) {
            throw new NoContentException("Nenhuma atração encontrada para o tipo especificado.");
        }
        return atracoes;
    }

    // Método de deleção encapsulado em transação
    @Transactional
    public void deleteAtracao(Long id) {
        // Busca a atração pelo ID
        Atracao atracao = buscarPorId(id);
        // Verifica se existem eventos associados à atração
        if (!eventoRepository.findByAtracaoId(id).isEmpty()) {
            throw new BadRequestException("Atração não pode ser deletada, pois está associada a um evento!");
        }
        // Deleta a atração se não houver eventos associados
        atracaoRepository.delete(atracao);
    }

}