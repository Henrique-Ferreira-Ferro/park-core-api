package com.ParqueCore.ParkBeto.model;

import com.ParqueCore.ParkBeto.enums.Classificacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private Classificacao classificacao;

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
