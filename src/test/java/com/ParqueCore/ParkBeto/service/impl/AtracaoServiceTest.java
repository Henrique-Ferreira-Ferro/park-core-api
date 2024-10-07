package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;

@RunWith(MockitoJUnitRunner.class)
public class AtracaoServiceTest {
	
	@Mock
	private AtracaoRepository atracaoRepository;

	@Mock
    private EventoRepository eventoRepository;
	
	@InjectMocks
	private AtracaoService atracao;
	
	@Test
	public void shouldVerifyisNomeUnique() {
		
	}
	
	@Test
	public void shouldCreateAtracao() {
		
	}
	
}
