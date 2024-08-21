package com.ParqueCore.ParkBeto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private int classificacao;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Visitante visitante;

    @ManyToOne
    @JoinColumn(name = "atracao_id")
    private Atracao atracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avaliacao_id", referencedColumnName = "id")
    private Avaliacao avaliacao;
}
