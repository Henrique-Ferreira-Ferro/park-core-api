package com.ParqueCore.ParkBeto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String comentarioModerador;

    @OneToOne(mappedBy = "avaliacao")
    private Feedback feedback;
}
