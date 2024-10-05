package com.ParqueCore.ParkBeto.service.impl;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.IngressoRepository;

@RunWith(MockitoJUnitRunner.class)
public class IngressoServiceTest {
	
	@Mock
	private IngressoRepository ingressoRepository;

	@InjectMocks
	private IngressoService ingressoService;
	
	
	
}
