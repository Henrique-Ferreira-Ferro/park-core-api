package com.ParqueCore.ParkBeto.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParqueCore.ParkBeto.model.Feedback;
import com.ParqueCore.ParkBeto.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	public Feedback realizarFeedback(Feedback feedback) {
		List<Feedback> feedbacks = new ArrayList<>();
		
		feedbacks.add(feedback);
		
		return feedbackRepository.save(feedback);
	}
	
	
}
