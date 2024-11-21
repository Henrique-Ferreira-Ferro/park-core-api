package com.ParkCore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ParkCore.dto.CepResponseDTO;
import com.ParkCore.service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {

	@Autowired
	private CepService cepService;
	
	@GetMapping("/address/{cep}")
	public ResponseEntity<CepResponseDTO> getAddress(@PathVariable("cep") String cep){
		CepResponseDTO response = cepService.getCep(cep);
		return new ResponseEntity<CepResponseDTO>(response, HttpStatus.OK); 
	}
	
}
