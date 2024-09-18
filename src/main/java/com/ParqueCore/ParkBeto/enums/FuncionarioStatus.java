package com.ParqueCore.ParkBeto.enums;

public enum FuncionarioStatus {
	ATIVO ("Ativo"),
	INATIVO ("Inativo");
	
	private final String status;
	
	FuncionarioStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
	
	
}
