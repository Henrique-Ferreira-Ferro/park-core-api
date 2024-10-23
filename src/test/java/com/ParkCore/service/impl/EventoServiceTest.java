package com.ParkCore.service.impl;

import com.ParkCore.repository.EventoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
