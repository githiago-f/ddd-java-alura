package org.example.school.domain.student;

public class StudentNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StudentNotFound(String cpf) {
        super("Aluno não encontrado com CPF: " + cpf);
    }

    public StudentNotFound() {
        super("Nenhum aluno encontrado");
    }
}
