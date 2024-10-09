package com.ParqueCore.ParkBeto.service.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;


@RunWith(MockitoJUnitRunner.class)
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
		given(visitante.getCpf()).willReturn("48574498911");
		given(visitante.getNome()).willReturn("Henrique");
		given(visitante.getTelefone()).willReturn("11947542211");
		
		//
		given(visitanteRepository.save(visitante)).willReturn(visitante);
		
		var result = visitanteService.cadastrarVisitante(visitante);
		
		//validar o que vem do result, se a expectativa bate com a realidade 
		then(result.getId()).equals(1l);
		then(result.getEmail()).equals("henrique@gmail.com");
		then(result.getCpf()).equals("48574498911");
		then(result.getNome()).equals("Henrique");
		then(result.getTelefone()).equals("11947542211");
		
		
	}
	
	@Test 
	public void deveExcluirVisitante() {
		
	}
	
	
	
	@Test
	void deveExcluirVisitanteComSucesso() {
		
	}
	
	@Test
	void deveLancarExcecaoQuandoVisitanteNaoForEncontrado() {
		
	}
	
	@Test
	void deveLancarExcecaoQuandoVisitanteTiverIngressosComprados() {
		
	}
	
	@Test
	void deveLancarExcecaoQuandoVisitanteTiverFeedbacksPendentes() {
		
	}
	
	
	
}
