package com.ParkCore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String moderatorComment;

    @OneToOne(mappedBy = "evaluation")
    private Feedback feedback;
}
