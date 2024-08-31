package com.ParqueCore.ParkBeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    public Visitante cadastrarVisitante(Visitante visitante) {
    	
    	if(validaCpf(visitante.getCpf()) == false) {
    		throw new RuntimeException("CPF invalido! Digite um CPF valido!");
    	}
    	
    	var visi = visitanteRepository.save(visitante);
    	
    	return visi;
    }
    
    
    
    
    public void excluirVisitante(Long visitanteId) {
        var visitante = visitanteRepository.findById(visitanteId)
                .orElseThrow(() -> new EntityNotFoundException("Visitante não encontrado"));

        if (visitanteRepository.hasIngressos(visitanteId)) {
            throw new BadRequestException("Não é possível remover o visitante com ingressos comprados");
        }

        if (visitanteRepository.hasFeedbacksPendentes(visitanteId)) {
            throw new BadRequestException("Não é possível remover o visitante com avaliações pendentes");
        }

        visitanteRepository.delete(visitante);
    }
    
    //Material de referencia utilizado:
    /*
     * https://medium.com/@edibertosilva33/validar-cpf-em-java-30be89fbc066
     * https://www.youtube.com/watch?v=d2uqo6PhdM4
     */
    public boolean validaCpf(String cpf) {
    	
    	cpf = cpf.replace("-", "");
    	cpf = cpf.replace(".", "");
    	
    	if(cpf.length() != 11 || cpf.equals("00000000000") || cpf.equals("11111111111") ||
        		cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444")
        		|| cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777")
        		|| cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.equals("01234567890")) {
        		return false;
        	}
    	
    	int totalSoma = 0;
    	for(int i = 0; i < 9; i++) {
    		totalSoma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
    	}
    	
    	int resultVerifica1 = totalSoma % 11;
    	
    	int digit1 = 0;
    	if(resultVerifica1 ==  0 || resultVerifica1 == 1) {
    		digit1 = 0;
    	}else {
    		digit1 = 11 - resultVerifica1 ;
    	}
    	
    	int totalSoma2 = 0;
    	for(int i = 0; i < 10; i++) {
    		totalSoma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
    	}
    	
    	int resultVerifica2 = totalSoma2 % 11;
    	
    	int digit2 = 0;
    	if(resultVerifica2 ==  0 || resultVerifica2 == 1) {
    		digit2 = 0;
    	}else {
    		digit2 = 11 - resultVerifica2 ;
    	}
    	
    	
    	if(Character.getNumericValue(cpf.charAt(9)) == digit1
    			&& Character.getNumericValue(cpf.charAt(10))== digit2) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
}
