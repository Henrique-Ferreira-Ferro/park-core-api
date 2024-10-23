package com.ParkCore.validation;

import com.ParkCore.model.Visitante;
import com.ParkCore.repository.VisitanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.ParkCore.util.ValidationUtils.*;

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
