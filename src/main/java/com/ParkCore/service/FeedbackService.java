package com.ParkCore.service;

import com.ParkCore.exceptions.BadRequestException;
import com.ParkCore.model.Feedback;
import com.ParkCore.repository.FeedbackRepository;
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
		if (feedback.getComment() == null || feedback.getComment().isEmpty()) {
			throw new BadRequestException("O comentário do feedback não pode ser vazio.");
		}
	}
}
