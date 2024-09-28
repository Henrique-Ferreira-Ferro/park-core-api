package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.atracao.Atracao;
import com.ParqueCore.ParkBeto.model.atracao.AtracaoTipo;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<Atracao> listaAtracoes(){
        return atracaoRepository.findAll();
    }

    public Atracao buscarPorId(long id){
        return atracaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atracao nao encontrada"));
    }

    public Atracao buscarPorNome(String nome){
        return atracaoRepository.findByNome(nome)
                .orElseThrow(() -> new EntityNotFoundException("Atracao com o nome: '"+ nome +"' nao foi encontrada"));
    }
    public List<Atracao> buscarPorTipo(AtracaoTipo tipo){
        return atracaoRepository.findByTipo(tipo);

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
