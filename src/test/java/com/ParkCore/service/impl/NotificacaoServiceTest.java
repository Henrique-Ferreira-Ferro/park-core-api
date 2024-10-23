package com.ParkCore.service.impl;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParkCore.repository.NotificacaoRepository;

@RunWith(MockitoJUnitRunner.class)
public class NotificacaoServiceTest {
	
	@Mock
	private NotificacaoRepository notificacaoRepository;
	
	@InjectMocks
	private NotificacaoService notificacaoService;
	
	
}
