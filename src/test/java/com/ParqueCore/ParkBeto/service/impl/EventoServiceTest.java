package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.EventoRepository;

@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {
	
	@Mock
	private EventoRepository eventoRepository;
	
	@InjectMocks
	private EventoService eventoService;
	
	
	
	@Test
	public void shouldCreateEvento() {
		
	}
	
}