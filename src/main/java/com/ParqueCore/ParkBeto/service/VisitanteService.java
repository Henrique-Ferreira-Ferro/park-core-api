package com.ParqueCore.ParkBeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParqueCore.ParkBeto.repository.VisitanteRepository;

@Service
public class VisitanteService {
	
	@Autowired
	private VisitanteRepository visitanteRepository;
	
}
