package com.ParqueCore.ParkBeto.enums;

public enum NotificacaoStatus {
	ENVIADA ("Enviada"),
	PENDENTE ("Pendente"),
	ENTREGUE ("Entregue");
	
	private final String status;
	
	NotificacaoStatus(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
	
}
