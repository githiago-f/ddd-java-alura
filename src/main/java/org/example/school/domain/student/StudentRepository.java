package org.example.school.domain.student;

import org.example.school.domain.student.entity.Student;

import java.util.List;

public interface StudentRepository {
    void register(Student student);

    Student findByCpf(String cpf);

    Student findByEmail(String email);

    List<Student> findAll();
}
