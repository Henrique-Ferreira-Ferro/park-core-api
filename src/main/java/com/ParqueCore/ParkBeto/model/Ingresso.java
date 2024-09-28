package com.ParqueCore.ParkBeto.model;

import com.ParqueCore.ParkBeto.model.atracao.Atracao;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String tipoIngresso;

    @ManyToOne
    @JoinColumn(name = "visitante_id", nullable = false)
    private Visitante visitante;

    @ManyToOne
    @JoinColumn(name = "atracao_id", nullable = false)
    private Atracao atracao;
}
