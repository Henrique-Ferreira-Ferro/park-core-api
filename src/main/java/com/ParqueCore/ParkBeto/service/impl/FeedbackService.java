package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.Feedback;
import com.ParqueCore.ParkBeto.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {

	private final FeedbackRepository feedbackRepository;

	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Transactional
	public Feedback realizarFeedback(Feedback feedback) {
		validarFeedback(feedback);

		return feedbackRepository.save(feedback);
	}

	private void validarFeedback(Feedback feedback) {
		if (feedback.getComentario() == null || feedback.getComentario().isEmpty()) {
			throw new BadRequestException("O comentário do feedback não pode ser vazio.");
		}
	}
}
