package com.ParqueCore.ParkBeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParqueCore.ParkBeto.repository.NotificacaoRepository;

@Service
public class NotificacaoService {
	
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
}
