package com.ParqueCore.ParkBeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParqueCore.ParkBeto.model.Feedback;
import com.ParqueCore.ParkBeto.service.impl.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/avaliar")
	public ResponseEntity<Feedback> realizarFeedback(@RequestBody Feedback feedback) {
		return ResponseEntity.status(201).body(feedbackService.realizarFeedback(feedback));
	}
	
	
}
