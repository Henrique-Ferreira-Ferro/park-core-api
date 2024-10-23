package com.ParkCore.service.impl;

import com.ParkCore.model.Evento;
import com.ParkCore.repository.EventoRepository;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

	private final EventoRepository eventoRepository;

	public EventoService(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	public Evento createEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
}
