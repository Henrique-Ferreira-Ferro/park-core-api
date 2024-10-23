package com.ParkCore.model;

import java.time.LocalDate;

import com.ParkCore.enums.NotificacaoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataEnvio;
	private NotificacaoStatus status;

	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;
	
}
