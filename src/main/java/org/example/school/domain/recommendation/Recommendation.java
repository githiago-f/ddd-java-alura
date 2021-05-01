package org.example.school.domain.recommendation;

import org.example.school.domain.student.entity.Student;

/**
 * Neste dominio, um conceito base
 * foi determinado como a possibilidade
 * de um aluno indicar outro aluno.
 * Esta classe representa uma relação entre dois
 * alunos, o indicador e o indicado.
 */
public class Recommendation {
    private final Student indicator;
    private final Student indicated;

    public Recommendation(Student indicator, Student indicated) {
        if(indicator.getCpf().equals(indicated.getCpf())) {
            throw new IllegalArgumentException("Can't indicate yourself!");
        }
        this.indicator = indicator;
        this.indicated = indicated;
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }
}
