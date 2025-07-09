package com.ParkCore.service;

import com.ParkCore.dto.CepResponseDTO;

import feign.Headers;
import feign.Param;
import feign.RequestLine;


public interface ZipCodeStackApi {
	
	@RequestLine("GET /v1/search?codes={codes}&country={country}&apikey={apiKey}")
	@Headers("Content-Type: application/json")
	CepResponseDTO getLocation(
			@Param("codes") String code,
			@Param("country") String country,
			@Param("apikey") String apikey
			);
	
	
}
