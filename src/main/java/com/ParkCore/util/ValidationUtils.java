package com.ParkCore.util;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{11}$");
    private static final String PHONE_REGEX = "^(\\(\\d{2}\\)\\s?)?(\\d{4,5}-\\d{4})$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public static boolean isPhoneNumberValid(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            return false;
        }
        return PHONE_PATTERN.matcher(telefone).matches();
    }

    public static boolean isCpfValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || CPF_PATTERN.matcher(cpf).matches() == false ||
                cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") ||
                cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
                cpf.equals("99999999999") || cpf.equals("01234567890")) {
            return false;
        }

        int totalSoma = 0;
        for (int i = 0; i < 9; i++) {
            totalSoma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resultVerifica1 = totalSoma % 11;
        int digit1 = (resultVerifica1 < 2) ? 0 : 11 - resultVerifica1;

        int totalSoma2 = 0;
        for (int i = 0; i < 10; i++) {
            totalSoma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        int resultVerifica2 = totalSoma2 % 11;
        int digit2 = (resultVerifica2 < 2) ? 0 : 11 - resultVerifica2;

        return Character.getNumericValue(cpf.charAt(9)) == digit1 &&
                Character.getNumericValue(cpf.charAt(10)) == digit2;
    }
}
