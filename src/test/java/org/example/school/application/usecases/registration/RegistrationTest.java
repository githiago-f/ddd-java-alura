package org.example.school.application.usecases.registration;

import org.example.school.application.usecases.registration.dto.StudentDto;
import org.example.school.domain.student.entity.Student;
import org.example.school.infrastructure.Cipher.PasswordCipherMD5;
import org.example.school.infrastructure.DAL.Memory.StudentRepositoryMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("#Registration (UseCase)")
class RegistrationTest {
    private Registration registration;
    private StudentRepositoryMemory studentRepositoryMemory;

    @BeforeEach
    void setUp() {
        studentRepositoryMemory = new StudentRepositoryMemory();
        registration = new Registration(studentRepositoryMemory, new PasswordCipherMD5());
    }

    @Test
    @DisplayName("Register new user")
    void registersNewUser() {
        StudentDto studentDto = new StudentDto(
                "Thiago Dutra",
                "thiago.dutra@shareprime.com.br",
                "000.000.000-00",
                "Senha123"
        );
        registration.execute(studentDto);

        assertDoesNotThrow(() -> studentRepositoryMemory.findByCpf("000.000.000-00"));
        Student student = studentRepositoryMemory.findByCpf("000.000.000-00");
        assertEquals("000.000.000-00", student.getCpf());
    }
}