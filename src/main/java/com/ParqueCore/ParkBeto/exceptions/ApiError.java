package com.ParqueCore.ParkBeto.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private int statusCode;
    private String message;
    private LocalDateTime date;
	public ApiError(int statusCode, String message, LocalDateTime date) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.date = date;
	}
    
    
 
    
}
