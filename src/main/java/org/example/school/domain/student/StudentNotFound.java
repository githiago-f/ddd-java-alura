package org.example.school.domain.student;

public class StudentNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StudentNotFound(String identity) {
        super("Aluno não encontrado com CPF/E-mail: " + identity);
    }

    public StudentNotFound() {
        super("Nenhum aluno encontrado");
    }
}
