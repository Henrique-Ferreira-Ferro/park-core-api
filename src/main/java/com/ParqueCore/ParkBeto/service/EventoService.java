package com.ParqueCore.ParkBeto.service;

import com.ParqueCore.ParkBeto.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParqueCore.ParkBeto.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;


	public Evento createEvento(Evento evento){
		return eventoRepository.save(evento);
	}
	
}
