package org.example.school.domain.student;

import org.example.school.domain.student.valueObject.Email;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("# Email")
class EmailTest {
    @Test
    @DisplayName("email@email.com is a valid email")
    public void givenEmailIsAValidEmail() {
        Email email = new Email("email@email.com");
        assertEquals("email@email.com", email.getEmail());
    }

    @Test
    @DisplayName("email@email will throw exception")
    public void givenEmailIsNotValid() {
        Executable invalidEmail = () -> new Email("email@email");
        assertThrows(InvalidParameterException.class, invalidEmail);
    }
}