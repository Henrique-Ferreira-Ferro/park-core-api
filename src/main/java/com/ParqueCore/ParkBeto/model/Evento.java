package com.ParqueCore.ParkBeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDate dataEvento;

    @ManyToOne
    @JoinColumn(name = "atracao_id", nullable = false)
    private Atracao atracao;

    @ElementCollection
    private List<String> recursosNecessarios;

    private String status;

    @ManyToMany(mappedBy = "eventos")
    private List<Visitante> participantesConfirmados;
    
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Notificacao> notificacoes;
    
    
}
