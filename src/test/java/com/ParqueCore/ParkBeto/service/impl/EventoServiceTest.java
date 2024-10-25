package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.repository.EventoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EventoServiceTest {
	
	@Mock
	private EventoRepository eventoRepository;
	
	@InjectMocks
	private EventoService eventoService;
	
	
	
	@Test
	public void shouldCreateEvento() {
		
	}
	
}
