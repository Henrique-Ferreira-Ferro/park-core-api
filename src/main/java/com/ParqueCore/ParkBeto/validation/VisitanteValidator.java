package com.ParqueCore.ParkBeto.validation;

import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.ParqueCore.ParkBeto.util.ValidationUtils.*;

@Component
public class VisitanteValidator {

	@Autowired
    private VisitanteRepository visitanteRepository;

    public static void validateCpfVisitante(Visitante visitante) {
        if(!isCpfValid(visitante.getCpf())) {
            throw new RuntimeException("CPF invalido! Digite um CPF valido!");
        }
    }

    public static void validateTelefoneVisitante(Visitante visitante) {
        if (isPhoneNumberValid(visitante.getTelefone())) {
            throw new RuntimeException("O número informado é inválido!");
        }
    }
}
