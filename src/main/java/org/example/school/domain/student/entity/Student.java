package org.example.school.domain.student.entity;

import org.example.school.domain.student.valueObject.CPF;
import org.example.school.domain.student.valueObject.Email;
import org.example.school.domain.student.valueObject.Telefone;

import java.util.ArrayList;
import java.util.List;

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
    private final String nome;

    /**
     * o email também poderia ser uma
     * identidade, porém, como é possivel mudar
     * de conta de email, o cpf foi adotado.
     */
    private final Email email;

    private final String senha;

    private final List<Telefone> telefones;

    public Student(CPF cpf, String nome, Email email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefones = new ArrayList<>();
        this.senha = senha;
    }
    public String getCpf() { return cpf.getValue(); }
    public String getEmail() { return email.getEmail(); }
    public String getNome() { return nome; }
    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
    }
}