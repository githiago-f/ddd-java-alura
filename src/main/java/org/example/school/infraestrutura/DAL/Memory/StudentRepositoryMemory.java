package org.example.school.infraestrutura.DAL.Memory;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.StudentNotFound;
import org.example.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMemory implements StudentRepository {
    private final List<Student> alunos;

    public StudentRepositoryMemory() {
        this.alunos = new ArrayList<>();
    }

    @Override
    public void matricula(Student aluno) {
        alunos.add(aluno);
    }

    @Override
    public Student buscaPorCpf(String cpf) {
        return alunos.stream()
                .filter((aluno -> aluno.getCpf().equals(cpf)))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> buscaTodos() {
        return alunos;
    }
}
