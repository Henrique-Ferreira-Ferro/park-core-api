package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParqueCore.ParkBeto.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;


	@PostMapping
	public ResponseEntity<Evento> createEvento(@PostMapping Evento evento){
		Evento newEvento = eventoService.createEvento(evento);
		return new ResponseEntity<>(newEvento, HttpStatus.CREATED);
	}


}
