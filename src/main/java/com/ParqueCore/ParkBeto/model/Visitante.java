package com.ParqueCore.ParkBeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "visitante", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    @OneToMany(mappedBy = "visitante", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @ManyToMany
    @JoinTable(
            name = "evento_participante",
            joinColumns = @JoinColumn(name = "visitante_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;
}