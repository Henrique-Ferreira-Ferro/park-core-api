package com.ParqueCore.ParkBeto.model;

import java.util.List;

import com.ParqueCore.ParkBeto.enums.FuncionarioStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private int telefone;
	private String cargo;
	private FuncionarioStatus status;
	private int horarioTrabalho;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	private List<Notificacao> notificacoes;
	
}
