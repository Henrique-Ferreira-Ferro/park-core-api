package com.ParkCore.service;

import com.ParkCore.model.Evaluation;
import com.ParkCore.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service

public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;


    public Evaluation save(Evaluation evaluation) {
        Evaluation save = new Evaluation();
        return save;
    }
}
