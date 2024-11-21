package com.ParkCore.service;

import com.ParkCore.exceptions.BadRequestException;
import com.ParkCore.model.Attraction;
import com.ParkCore.model.Feedback;
import com.ParkCore.model.Visitor;
import com.ParkCore.repository.FeedbackRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class FeedbackService {

	private final FeedbackRepository feedbackRepository;

	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Transactional
	public Feedback realizarFeedback(Feedback feedback) {
		validateFeedback(feedback);

		return feedbackRepository.save(feedback);
	}

	private void validateFeedback(@org.jetbrains.annotations.NotNull Feedback feedback) {
		if (feedback.getComment() == null || feedback.getComment().isEmpty()) {
			throw new BadRequestException("O comentário do feedback não pode ser vazio.");
		}


		@Setter
        @Getter
        @Entity
		@Table(name = "feedback" )
        class feedback{

            @GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id_avaliacao")
			private Long idAvaliacao;

			@ManyToOne
			@JoinColumn(name = "id_visitor", referencedColumnName = "id_visitor")
			private Visitor visitor;

			@ManyToOne
			@JoinColumn(name = "id_atracion", referencedColumnName = "id_atracion")
			private Attraction attraction;

			@Column(name = "text avaliacion", length = 1000)
			private String textoAvaliacao;

			@Column(name = "classificacion")
			private int classificacao;

			@Column(name = "classificacion")
			private LocalDateTime CreatDate;


			public Object Feedback (LocalDateTime CreatDate) {
                //noinspection DataFlowIssue
                return CreatDate = CreatDate;
			}

        }



	}
}
