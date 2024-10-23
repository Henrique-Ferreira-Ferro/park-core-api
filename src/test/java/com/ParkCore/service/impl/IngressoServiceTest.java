package com.ParkCore.service.impl;

import com.ParkCore.repository.IngressoRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngressoServiceTest {
	
	@Mock
	private IngressoRepository ingressoRepository;

	@InjectMocks
	private IngressoService ingressoService;
	
	
	
}
