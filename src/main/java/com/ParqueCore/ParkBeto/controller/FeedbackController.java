package com.ParqueCore.ParkBeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParqueCore.ParkBeto.model.Feedback;
import com.ParqueCore.ParkBeto.service.impl.FeedbackService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@Operation(summary = "Realizar um feedback", description = "Essa funcionalidade permite um usuario realizar um feedback de um evento")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Avaliação feita com sucesso!",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Feedback.class)
				)
			),
			@ApiResponse(responseCode = "400", description = "Erro ao realizar a avalicação")
	})
	@PostMapping("/avaliar")
	public ResponseEntity<Feedback> realizarFeedback(@RequestBody Feedback feedback) {
		return ResponseEntity.status(201).body(feedbackService.realizarFeedback(feedback));
	}
	
	
}
