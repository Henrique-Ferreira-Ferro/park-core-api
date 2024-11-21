package com.ParkCore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.awt.*;

import static java.awt.SystemColor.text;

@Data
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String moderatorComment;
    private String text;

    @Setter
    @OneToOne(mappedBy = "evaluation")
    private Feedback feedback;
    
    public Integer getClassification() {
        return 1; 
    }


    public CharSequence getText() {
        return text;
    }

}