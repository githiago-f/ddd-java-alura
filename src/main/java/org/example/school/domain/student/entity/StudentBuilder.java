package org.example.school.domain.student.entity;

import org.example.school.domain.student.valueObject.CPF;
import org.example.school.domain.student.valueObject.Email;

public class StudentBuilder {
    private String name;
    private CPF cpf;
    private Email email;
    private String senha;

    public StudentBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder withCpf(String cpf) {
        this.cpf = new CPF(cpf);
        return this;
    }

    public StudentBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public StudentBuilder withSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Student build() {
        return new Student(cpf, name, email, senha);
    }
}
