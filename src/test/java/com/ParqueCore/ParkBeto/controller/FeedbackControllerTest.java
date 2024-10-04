package com.ParqueCore.ParkBeto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.ParqueCore.ParkBeto.service.impl.FeedbackService;

@WebMvcTest
public class FeedbackControllerTest {

	@Mock
	private FeedbackService feedbackService;
	
	@InjectMocks
	private FeedbackController feedbackController;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void shouldRealizarFeedback() {
		
	}
	
	
}
