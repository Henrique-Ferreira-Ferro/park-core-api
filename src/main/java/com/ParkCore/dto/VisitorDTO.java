package com.ParkCore.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisitorDTO {

	private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
	
    private List<TicketDTO> tickets;
    private List<FeedbackDTO> feedbacks;
    private List<NotificationDTO> notifications;
    private List<EventDTO> events;
    
    
}
