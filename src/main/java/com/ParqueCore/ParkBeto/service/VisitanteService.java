package com.ParqueCore.ParkBeto.service;

import java.util.List;

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
        
    	if(!validaCpf(visitante.getCpf())) {
    		throw new RuntimeException("CPF invalido! Digite um CPF valido!");
    	}
    	
    	if(verificaCpf(visitante.getCpf()) == true) {
    		throw new RuntimeException("O CPF já está cadastrado no sistema!");
    	}
    	
    	if(!verificaNumero(visitante.getTelefone())) {
    		throw new RuntimeException("O Numero informado é invalido!");
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
	
	
	//Metodos não relacionados ao crud da aplicação!!!!!!!!
    public boolean validaCpf(String cpf) {
    	    	
    	
    	
    	if(cpf.length() != 11 || cpf.equals("00000000000") || cpf.equals("11111111111") ||
        		cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444")
        		|| cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777")
        		|| cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.equals("01234567890")
        		|| !cpf.matches("(\\d{11})")
    			) {
        		return false;
        	}
    	//123456789201
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
    
 // Metodo para verficar se um Cpf já existe no sistema
    
    private boolean verificaCpf(String cpf) {
    	List<Visitante> visitantes = visitanteRepository.findAll();
    	
    	for (Visitante visitante : visitantes) {
			if(visitante.getCpf().equals(cpf)) {
				return true;
			}
		}
    	
    	return false;
    	
    }
    
    
    private boolean verificaNumero(String telefone) {

    	String regex = "(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}\\-?\\d{4})";
    	
    	if(!telefone.matches(regex)) {
    		return false;
    	}
    	return true;
	}
    
    
}