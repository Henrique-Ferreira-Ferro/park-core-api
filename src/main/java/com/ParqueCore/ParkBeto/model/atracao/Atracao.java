package com.ParqueCore.ParkBeto.model.atracao;



import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.model.Feedback;
import com.ParqueCore.ParkBeto.model.Ingresso;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Atracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private AtracaoTipo tipo;

    private int capacidadeMaxima;



    @OneToMany(mappedBy = "atracao", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    @OneToMany(mappedBy = "atracao", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "atracao", cascade = CascadeType.ALL)
    private List<Evento> eventos;

    public String getNome() {
        return nome;
    }
}
