package com.ParkCore.controller;

import com.ParkCore.service.impl.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	private AvaliacaoService evaluationService;

}
