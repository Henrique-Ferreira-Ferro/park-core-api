package com.ParkCore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String tipoIngresso;
    private Date dataEmissao;
    private String tipo;
    private String status;
    private Date dataVisita;

    @ManyToOne
    @JoinColumn(name = "visitante_id", nullable = false)
    private Visitante visitante;

    @ManyToOne
    @JoinColumn(name = "atracao_id", nullable = false)
    private Atracao atracao;
}
