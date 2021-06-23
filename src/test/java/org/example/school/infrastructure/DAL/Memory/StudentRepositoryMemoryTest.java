package org.example.school.infrastructure.DAL.Memory;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.builders.StudentBuilder;
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
                .withPassword("123456")
                .build();
        Student student1 = new StudentBuilder()
                .withCpf("000.999.999-91")
                .withEmail("email@email.com")
                .withName("Thiago Dutra")
                .withPassword("123456")
                .build();
        studentRepository.register(student1);
    }

    @Test
    @DisplayName("Matricula aluno")
    void registration() {
        String cpf = "000.999.999-99";
        studentRepository.register(student);
        assertDoesNotThrow(() -> studentRepository.findAll());
        assertEquals(cpf, studentRepository.findAll().get(1).getCpf());
    }

    @Test
    @DisplayName("Busca por cpf existente")
    void searchByCPF() {
        String cpf = "000.999.999-91";
        assertDoesNotThrow(() -> studentRepository.findByCpf(cpf));
        Student localStudent = studentRepository.findByCpf(cpf);
        assertEquals(cpf, localStudent.getCpf());
    }

    @Test
    @DisplayName("Busca por cpf inexistente")
    void searchByCPFNonexistent() {
        String cpf = "000.999.999-99";
        assertThrows(StudentNotFound.class, () -> studentRepository.findByCpf(cpf));
    }

    @Test
    @DisplayName("Busca todos alunos")
    void searchAll() {
        List<Student> students = studentRepository.findAll();
        assertEquals(1, students.size());
        assertEquals("email@email.com", students.get(0).getEmail());
    }
}