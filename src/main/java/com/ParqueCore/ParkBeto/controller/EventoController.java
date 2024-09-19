package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.service.impl.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@PostMapping
	public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
		var newEvento = eventoService.createEvento(evento);
		return new ResponseEntity<>(newEvento, CREATED);
	}

}
