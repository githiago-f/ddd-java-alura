package org.example.school.domain.student;

import org.example.school.domain.student.entity.Student;

import java.util.List;

public interface StudentRepository {
    void matricula(Student aluno);

    Student buscaPorCpf(String cpf);

    List<Student> buscaTodos();
}
