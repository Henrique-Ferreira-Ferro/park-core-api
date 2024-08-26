package com.ParqueCore.ParkBeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParqueCore.ParkBeto.service.IngressoService;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {

	@Autowired
	private IngressoService ingressoService;
	
}
