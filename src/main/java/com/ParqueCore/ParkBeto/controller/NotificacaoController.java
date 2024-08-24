package com.ParqueCore.ParkBeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParqueCore.ParkBeto.service.NotificacaoService;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {
	
	@Autowired
	private NotificacaoService notificacaoService;
	
}
