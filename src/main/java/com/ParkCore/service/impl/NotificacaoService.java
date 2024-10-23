package com.ParkCore.service.impl;

import com.ParkCore.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
	
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
}
