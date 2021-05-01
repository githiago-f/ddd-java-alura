package org.example.school.domain.recommendation;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.StudentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("# Indicação")
class RecommendateStudentTest {
    private Student studentA;
    private Student studentB;
    private Student studentC;

    @BeforeEach
    void setUp() {
        studentA = new StudentBuilder().withName("Thiago Dutra")
            .withEmail("email@email.com")
            .withCpf("000.000.000-00")
            .build();
        studentB = new StudentBuilder().withName("Dutra Thiago")
            .withCpf("000.000.000-01")
            .withEmail("email@email.com.br")
            .build();
        studentC = new StudentBuilder().withName("John Doe")
            .withEmail("email2@email.com")
            .withCpf("000.000.000-00")
            .build();
    }

    @Test
    @DisplayName("Indica outro aluno")
    public void cantIndicateSameUsers() {
        Recommendation recommendation = new Recommendation(studentA, studentB);
        assertEquals("000.000.000-00", recommendation.getIndicator().getCpf());
        assertEquals("000.000.000-01", recommendation.getIndicated().getCpf());
    }

    @Test
    @DisplayName("Não pode indicar usuário de mesmo CPF")
    public void canIndicateDifferentUsers() {
        Executable indicacao = () -> new Recommendation(studentA, studentC);
        assertThrows(IllegalArgumentException.class, indicacao);
    }
}