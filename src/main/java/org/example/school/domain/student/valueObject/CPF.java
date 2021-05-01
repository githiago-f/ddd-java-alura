package org.example.school.domain.student.valueObject;

import java.security.InvalidParameterException;
import java.util.Objects;

public class CPF {
    private final String cpf;
    public CPF(String cpf) {
        if(isNotValid(cpf)) {
            throw new InvalidParameterException("invalid CPF!");
        }
        this.cpf = cpf;
    }

    /**
     * Esta não é a melhor representação de uma
     * validação de cpf.
     */
    private boolean isNotValid(String cpf) {
        return !cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
    }

    public String getValue() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf1 = (CPF) o;
        return Objects.equals(cpf, cpf1.cpf);
    }
}
