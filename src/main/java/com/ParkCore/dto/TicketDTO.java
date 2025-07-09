package com.ParkCore.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

	private Long id;
    private String code;
    private String ticketType;
    private Date issueDate;
    private String type;
    private String status;
    private Date visitDate;
	
    private VisitorDTO visitor;
    
    private AttractionDTO attraction;
    
}
