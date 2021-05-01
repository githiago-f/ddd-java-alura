package org.example.school.domain.student.valueObject;

public class Telefone {
    private final String number;
    public Telefone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
