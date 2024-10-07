package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.FeedbackRepository;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackServiceTest {
	
	@Mock
	private FeedbackRepository feedbackRepository;

	@InjectMocks
	private FeedbackService feedbackService;
	
	
	@Test
	public void shouldRealizarFeedback() {
		
	}
	
	
}
