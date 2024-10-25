package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.model.Ingresso;
import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.IngressoRepository;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class IngressoServiceTest {

	@Mock
	private IngressoRepository ingressoRepository;
	@Mock
	private VisitanteRepository visitanteRepository;
	@Mock
	private AtracaoRepository atracaoRepository;
	@InjectMocks
	private IngressoService ingressoService;


	@Test
	public void deveEmitirIngressoComSucesso() {
		var ingressoRequest = mock(Ingresso.class);
		var visitante = mock(Visitante.class);
		var atracao = mock(Atracao.class);

		given(ingressoRequest.getVisitante()).willReturn(visitante);
		given(ingressoRequest.getAtracao()).willReturn(atracao);
		given(ingressoRequest.getTipo()).willReturn("inteiro");
		given(ingressoRequest.getStatus()).willReturn("ativo");
		given(ingressoRequest.getDataVisita()).willReturn(new Date());
		given(visitante.getId()).willReturn(1L);
		given(atracao.getId()).willReturn(1L);

		given(visitanteRepository.findById(1L)).willReturn(Optional.of(visitante));
		given(atracaoRepository.findById(1L)).willReturn(Optional.of(atracao));


		var result = ingressoService.emitirIngresso(ingressoRequest);


	}
}
