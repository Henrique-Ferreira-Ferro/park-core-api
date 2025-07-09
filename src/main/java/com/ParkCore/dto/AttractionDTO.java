package com.ParkCore.dto;

import java.util.List;

import com.ParkCore.enums.AttractionType;
import com.ParkCore.model.Attraction;
import com.ParkCore.model.Ticket;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttractionDTO {
	
	private Long id;
    private String name;
    private String description;
    private int maximumCapacity;
    
    
    @Enumerated(EnumType.STRING)
    private AttractionType type;
    
    private List<TicketDTO> tickets;
    private List<FeedbackDTO> feedbacks;
    private List<EventDTO> events;
    
    public AttractionDTO(Attraction attraction) {
    	this.id = attraction.getId();
    	this.name = attraction.getName();
    	this.description = attraction.getDescription();
    	this.maximumCapacity = attraction.getMaximumCapacity();
    	this.type = attraction.getType();
    	//this.tickets = attraction.getTickets();
    	//this.feedbacks = attraction.getFeedbacks();
    	//this.events = attraction.getEvents();
    }
    
    
}
