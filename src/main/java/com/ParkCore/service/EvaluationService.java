package com.ParkCore.service;

import com.ParkCore.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;


}
