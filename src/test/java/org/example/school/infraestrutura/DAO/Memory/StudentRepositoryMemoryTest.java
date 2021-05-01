package org.example.school.infraestrutura.DAO.Memory;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.StudentBuilder;
import org.example.school.domain.student.StudentNotFound;
import org.example.school.domain.student.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("# Repositório de alunos")
class StudentRepositoryMemoryTest {

    private StudentRepository studentRepository;
    private Student student;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepositoryMemory();
        student = new StudentBuilder()
                .withCpf("000.999.999-99")
                .withEmail("email1@email.com")
                .withName("Thiago Farias")
                .withSenha("123456")
                .build();
        Student student1 = new StudentBuilder()
                .withCpf("000.999.999-91")
                .withEmail("email@email.com")
                .withName("Thiago Dutra")
                .withSenha("123456")
                .build();
        studentRepository.matricula(student1);
    }

    @Test
    @DisplayName("Matricula aluno")
    void registration() {
        String cpf = "000.999.999-99";
        studentRepository.matricula(student);
        assertDoesNotThrow(() -> studentRepository.buscaTodos());
        assertEquals(cpf, studentRepository.buscaTodos().get(1).getCpf());
    }

    @Test
    @DisplayName("Busca por cpf existente")
    void searchByCPF() {
        String cpf = "000.999.999-91";
        assertDoesNotThrow(() -> studentRepository.buscaPorCpf(cpf));
        Student localStudent = studentRepository.buscaPorCpf(cpf);
        assertEquals(cpf, localStudent.getCpf());
    }

    @Test
    @DisplayName("Busca por cpf inexistente")
    void searchByCPFNonexistent() {
        String cpf = "000.999.999-99";
        assertThrows(StudentNotFound.class, () -> studentRepository.buscaPorCpf(cpf));
    }

    @Test
    @DisplayName("Busca todos alunos")
    void searchAll() {
        List<Student> students = studentRepository.buscaTodos();
        assertEquals(1, students.size());
        assertEquals("email@email.com", students.get(0).getEmail());
    }
}