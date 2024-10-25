package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTest {
	
	@Mock
	private FeedbackRepository feedbackRepository;

	@InjectMocks
	private FeedbackService feedbackService;
	
	
	@Test
	public void shouldRealizarFeedback() {
		
	}
	
	
}
