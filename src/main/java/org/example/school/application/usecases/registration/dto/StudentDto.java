package org.example.school.application.usecases.registration.dto;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.StudentBuilder;

public class StudentDto {
    public String name;
    public String email;
    public String cpf;

    public StudentDto(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Student toModel() {
        return new StudentBuilder()
                .withCpf(cpf)
                .withEmail(email)
                .withName(name)
                .build();
    }
}
