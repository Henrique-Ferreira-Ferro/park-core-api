package com.ParqueCore.ParkBeto.enums;

public enum Classificacao {
	
	EXCELENTE ("Excelente"),
	BOM ("Bom"),
	OTIMO ("Otimo"),
	OK ("Ok"),
	REGULAR ("Regular"),
	RUIM ("Ruim"),
	PÉSSIMO ("Péssimo"),
	HORRIVEL ("Horrivel");
	
	private String classifica;
	
	 Classificacao(String classifica) {
		this.classifica = classifica;
	}

	public String getClassifica() {
		return classifica;
	}
	
	
}
