package com.ParkCore.controller;

import com.ParkCore.model.Evaluation;
import com.ParkCore.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Object> createEvaluation(@RequestBody Evaluation evaluation) {

        if (evaluation.getClassification() < 1 || evaluation.getClassification() > 5) {
            return ResponseEntity.badRequest().body(null);
        }
        if (evaluation.getText().length() > 500) {
            return ResponseEntity.badRequest().body(null);
        }

        Evaluation newEvaluation = evaluationService.save(evaluation);
        return ResponseEntity.ok(newEvaluation);
    }
}