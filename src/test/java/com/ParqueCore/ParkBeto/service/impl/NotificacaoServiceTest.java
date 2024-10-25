package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.repository.NotificacaoRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificacaoServiceTest {
	
	@Mock
	private NotificacaoRepository notificacaoRepository;
	
	@InjectMocks
	private NotificacaoService notificacaoService;
	
	
}
