package org.example.school.application.usecases.registration.dto;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.builders.StudentBuilder;

public class StudentDto {
    private final String name;
    private final String email;
    private final String cpf;
    public String password;

    public StudentDto(String name, String email, String cpf, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public Student toModel() {
        return new StudentBuilder()
                .withCpf(cpf)
                .withEmail(email)
                .withName(name)
                .withPassword(password)
                .build();
    }
}
