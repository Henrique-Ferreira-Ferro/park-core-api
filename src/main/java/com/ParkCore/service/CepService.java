package com.ParkCore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ParkCore.dto.CepResponseDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CepService {
	
	
	ZipCodeStackApi zipCodeStackApi;
	
	@Value("${zipcode.api.key}")
	String apikey;
	
	
	public CepResponseDTO getCep(String Cep, String country) {
		
		try {
			return zipCodeStackApi.getLocation(Cep, country, apikey);
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
