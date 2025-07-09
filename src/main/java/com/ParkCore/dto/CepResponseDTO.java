package com.ParkCore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CepResponseDTO {

	public String postal_code;
    public String country_code;
    public double latitude;
    public double longitude;
    public String city;
    public String state;
    public String city_en;
    public String state_en;
    public String state_code;
    
    
    
}
