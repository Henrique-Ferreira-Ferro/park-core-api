package com.ParqueCore.ParkBeto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.ParqueCore.ParkBeto.service.impl.AtracaoService;

@WebMvcTest
public class AtracaoControllerTest {
	
	 @Autowired
	 @Mock
	 private AtracaoService atracaoService;
	
	 @InjectMocks
	 private AtracaoController atracaoController;
	 
	 @BeforeEach
	 void setup() {
		 MockitoAnnotations.initMocks(this);
		 
	 }
	 
	 @Test
	 void shouldCreateAtracao() {
		 
	 }

	 @Test
	 void shouldDeleteAtracao() {
		 
	 }
	 
	 
}
