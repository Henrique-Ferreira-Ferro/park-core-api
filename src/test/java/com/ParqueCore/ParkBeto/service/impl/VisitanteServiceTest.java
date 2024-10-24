package com.ParqueCore.ParkBeto.service.impl;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class VisitanteServiceTest {

    @Mock
    private VisitanteRepository visitanteRepository;

    @InjectMocks
    private VisitanteService visitanteService;


    @Test
    public void deveCadastrarVisitante() {

        //cenario
        //Forma de instanciar visitante
        //Permite usar o GIven e setar dados
        var visitante = mock(Visitante.class);

        //Dado o id do visitante, quero que o retorno seja 1 l (long)
        //simula uma ação
        given(visitante.getId()).willReturn(1l);
        given(visitante.getEmail()).willReturn("henrique@gmail.com");
        given(visitante.getCpf()).willReturn("83735288065");
        given(visitante.getNome()).willReturn("Henrique");
        given(visitante.getTelefone()).willReturn("11947542211");

        given(visitanteRepository.save(visitante)).willReturn(visitante);
        var result = visitanteService.cadastrarVisitante(visitante);

        //validar o que vem do result, se a expectativa bate com a realidade
        assertEquals(1l, result.getId());
        assertEquals("henrique@gmail.com", result.getEmail());
        assertEquals("83735288065", result.getCpf());
        assertEquals("Henrique", result.getNome());
        assertEquals("11947542211", result.getTelefone());

    }

    @Test
    public void deveExcluirVisitante() {

        //cenario
        //Forma de instanciar visitante
        //Permite usar o GIven e setar dados
        var visitante = mock(Visitante.class);

        //Dado o id do visitante, quero que o retorno seja 1 l (long)
        //simula uma ação
        given(visitante.getId()).willReturn(1L);

        given(visitanteRepository.findById(visitante.getId())).willReturn(Optional.of(visitante));

        visitanteService.excluirVisitante(visitante.getId());
        //verify(visitanteRepository,times(1)).;

    }


    @Test
    void deveLancarExcecaoQuandoVisitanteNaoForEncontrado() {
        thenThrownBy(() -> visitanteService.excluirVisitante(null)).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void deveLancarExcecaoQuandoVisitanteTiverIngressosComprados() {

        //cenario
        //Forma de instanciar visitante
        //Permite usar o GIven e setar dados
        var visitante = mock(Visitante.class);

        //Dado o id do visitante, quero que o retorno seja 1 l (long)
        //simula uma ação


        given(visitanteRepository.findById(visitante.getId())).willReturn(Optional.of(visitante));
        given(visitanteRepository.hasIngressos(visitante.getId())).willReturn(true);


        thenThrownBy(() -> visitanteService.excluirVisitante(visitante.getId())).isInstanceOf(BadRequestException.class);


    }

    @Test
    void deveLancarExcecaoQuandoVisitanteTiverFeedbacksPendentes() {

        //cenario
        //Forma de instanciar visitante
        //Permite usar o GIven e setar dados
        var visitante = mock(Visitante.class);

        //Dado o id do visitante, quero que o retorno seja 1 l (long)
        //simula uma ação


        given(visitanteRepository.findById(visitante.getId())).willReturn(Optional.of(visitante));
        given(visitanteRepository.hasIngressos(visitante.getId())).willReturn(true);


        thenThrownBy(() -> visitanteService.excluirVisitante(visitante.getId())).isInstanceOf(BadRequestException.class);

    }


}
