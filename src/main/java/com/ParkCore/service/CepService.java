package com.ParkCore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ParkCore.dto.CepResponseDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CepService {
	
	public CepResponseDTO getCep(String Cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		String UrlApi = "https://api.zipcodestack.com/v1/search?codes="+Cep+"&country=br&apikey=01JD77444HGRAJ7SBTXB699VRP";
		CepResponseDTO response = restTemplate.getForObject(UrlApi, CepResponseDTO.class);
		return response;
	}
	
	
}
