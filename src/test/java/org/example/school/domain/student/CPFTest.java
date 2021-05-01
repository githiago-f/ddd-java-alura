package org.example.school.domain.student;

import org.example.school.domain.student.valueObject.CPF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("# CPF")
class CPFTest {
    @Test
    @DisplayName("should be a valid cpf")
    public void givenCPFIsValid() {
        CPF cpf = new CPF("000.000.000-00");
        assertEquals("000.000.000-00", cpf.getValue());
    }
    
    @Test
    @DisplayName("should be a invalid cpf")
    public void givenCPFWillThrowError() {
        Executable invalidCpf = () -> new CPF("000.000-99");
        assertThrows(InvalidParameterException.class, invalidCpf);
    }
}