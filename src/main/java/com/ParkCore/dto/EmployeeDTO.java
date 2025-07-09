package com.ParkCore.dto;

import java.util.List;

import com.ParkCore.enums.EmployeeStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
	
	private Long id;
    private String name;
    private String cpf;
    private String email;
    private int phone;
    private String position;
    private EmployeeStatus status;
    private int workingHours;
	
    private List<NotificationDTO> notifications;
    
    
    
    
}
