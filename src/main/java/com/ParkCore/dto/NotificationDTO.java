package com.ParkCore.dto;

import java.time.LocalDate;

import com.ParkCore.enums.NotificationStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NotificationDTO {
	
	private Long id;
    private String name;
    private LocalDate sendDate;
    private NotificationStatus status;
	
    private EmployeeDTO employee;
	
    private VisitorDTO visitor;
    
    private EventDTO event;
    
}
