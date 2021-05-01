package org.example.school.application.usecases.registration;

import org.example.school.application.usecases.registration.dto.StudentDto;
import org.example.school.domain.student.entity.Student;
import org.example.school.infraestrutura.DAO.Memory.StudentRepositoryMemory;
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
        registration = new Registration(studentRepositoryMemory);
    }

    @Test
    @DisplayName("Register new user")
    void registersNewUser() {
        StudentDto studentDto = new StudentDto(
                "Thiago Dutra",
                "thiago.dutra@shareprime.com.br",
                "046.773.300-77"
        );
        registration.execute(studentDto);

        assertDoesNotThrow(() -> studentRepositoryMemory.buscaPorCpf("046.773.300-77"));
        Student student = studentRepositoryMemory.buscaPorCpf("046.773.300-77");
        assertEquals("046.773.300-77", student.getCpf());
    }
}