package org.example.school.infrastructure.DAL.Memory;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.StudentNotFound;
import org.example.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMemory implements StudentRepository {
    private final List<Student> students;

    public StudentRepositoryMemory() {
        this.students = new ArrayList<>();
    }

    @Override
    public void register(Student student) {
        students.add(student);
    }

    @Override
    public Student findByCpf(String cpf) {
        return students.stream()
                .filter((student -> student.getCpf().equals(cpf)))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public Student findByEmail(String email) {
        return students.stream()
                .filter((student -> student.getEmail().equals(email)))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(email));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}
