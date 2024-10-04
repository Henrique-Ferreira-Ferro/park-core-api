package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.NotificacaoRepository;

@RunWith(MockitoJUnitRunner.class)
public class NotificacaoServiceTest {
	
	@Mock
	private NotificacaoRepository notificacaoRepository;
	
	@InjectMocks
	private NotificacaoService notificacaoService;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
}
