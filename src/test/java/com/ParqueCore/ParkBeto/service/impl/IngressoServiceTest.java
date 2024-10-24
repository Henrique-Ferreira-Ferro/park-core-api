package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.model.Ingresso;
import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import com.ParqueCore.ParkBeto.repository.IngressoRepository;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class IngressoServiceTest {

	@Mock
	private IngressoRepository ingressoRepository;
	@Mock
	private VisitanteRepository visitanteRepository;
	@Mock
	private AtracaoRepository atracaoRepository;
	@InjectMocks
	private IngressoService ingressoservice;
	@Test
	public void deveEmitirIngressoComSucesso(){
		var atracao = mock(Atracao.class);
		var visitante = mock(Visitante.class);
		var ingresso = mock(Ingresso.class);

		given(visitante.getId()).willReturn(1L);
		given(visitante.getNome()).willReturn("Gabby");
		given(visitante.getCpf()).willReturn("15214515810");
		given(visitante.getTelefone()).willReturn("1515515");
		given(visitante.getEmail()).willReturn("gabby@gamil.com");

		given(atracao.getId()).willReturn(1L);
		given(atracao.getNome()).willReturn("Montanha Russa");
		given(atracao.getIngressos()).willReturn(List.of());
		given(atracao.getDescricao()).willReturn("Perigoso");

		given(ingresso.getDataEmissao()).willReturn(new Date());
		given(ingresso.getId()).willReturn(1L);
		given(ingresso.getTipoIngresso()).willReturn("adulto");
		given(ingresso.getStatus()).willReturn("Ativo");
		given(ingresso.getAtracao()).willReturn(atracao);

		given(visitanteRepository.findById(1L)).willReturn(Optional.of(visitante));
		given(atracaoRepository.findById(1L)).willReturn(Optional.of(atracao));
		given(ingressoRepository.save(any(Ingresso.class))).willReturn(ingresso);

		var result = ingressoservice.emitirIngresso(ingresso);

		assertEquals("Montanha Russa", result.getAtracao().getNome());
		assertEquals("adulto", result.getTipoIngresso());
		assertEquals("Ativo", result.getStatus());
		assertEquals(visitante.getId(), result.getVisitante().getId());
		assertEquals(atracao.getId(), result.getAtracao().getId());
	}
}
