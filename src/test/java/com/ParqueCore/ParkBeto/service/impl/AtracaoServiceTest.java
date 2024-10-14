package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class AtracaoServiceTest {

	@Mock
	private AtracaoRepository atracaoRepository;

	@Mock
	private EventoRepository eventoRepository;

	@InjectMocks
	private AtracaoService atracaoService;

	@Test
	public void deveCadastrarAtracao() {
		// Cenario
		var atracao = mock(Atracao.class);

		// Simulando os dados da atração
		given(atracao.getId()).willReturn(1L);
		given(atracao.getNome()).willReturn("Montanha Russa");
		given(atracao.getDescricao()).willReturn("Uma incrível montanha russa!");
		given(atracao.getTipo()).willReturn(AtracaoTipo.MONTANHA_RUSSA);
		given(atracao.getCapacidadeMaxima()).willReturn(50);

		// Simula a ação de salvar a atração no repositório
		given(atracaoRepository.save(atracao)).willReturn(atracao);

		// Quando
		var result = atracaoService.createAtracao(atracao);

		// Validação
		assertEquals(1L, result.getId());
		assertEquals("Montanha Russa", result.getNome());
		assertEquals("Uma incrível montanha russa!", result.getDescricao());
		assertEquals(AtracaoTipo.MONTANHA_RUSSA, result.getTipo());
		assertEquals(50, result.getCapacidadeMaxima());
	}


	@Test
	public void shouldVerifyisNomeUnique() {
		
	}
	
	@Test
	public void shouldCreateAtracao() {
		
	}
	
}
