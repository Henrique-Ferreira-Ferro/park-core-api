package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
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
