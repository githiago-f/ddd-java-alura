package org.example.school.domain.student.entity;

import org.example.school.domain.student.valueObject.CPF;
import org.example.school.domain.student.valueObject.Email;

/**
 * Este conceito possui uma identificação (CPF)
 * então pode ser tratado como Entidade
 */
public class Student {
    /**
     * a identidade deste objeto é determinada
     * pela propriedade CPF para que se assemelhe
     * à forma em que os especialistas o chamam!
     *
     * Um especialista do dominio chamaria um aluno pelo
     * CPF pois é o dado de identificação que se utiliza no país.
     */
    private final CPF cpf;

    /**
     * nomes podem ser repetidos e por isso
     * não são boas identidades
     */
    private final String name;

    /**
     * o email também poderia ser uma
     * identidade, porém, como é possivel mudar
     * de conta de email, o cpf foi adotado.
     */
    private final Email email;

    private final String password;

    public Student(CPF cpf, String name, Email email, String password) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getCpf() { return cpf.getValue(); }
    public String getEmail() { return email.getEmail(); }
    public String getName() { return name; }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student{\n" +
                " cpf=" + cpf.getValue() +
                ",\n name='" + name + '\'' +
                ",\n email=" + email.getEmail() +
                ",\n password='" + password + '\'' +
                '}';
    }
}
