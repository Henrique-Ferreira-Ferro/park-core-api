package com.ParkCore.dto;

import com.ParkCore.enums.Classification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackDTO {
	
	private Long id;
    private String comment;
    private Classification classification;
	
    private VisitorDTO visitor;
    private AttractionDTO attraction;
    
    
}
