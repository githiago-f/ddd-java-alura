package org.example.school.domain.student.valueObject;

import java.security.InvalidParameterException;

public class Email {
    private final String email;
    public Email(String email) {
        String regex = "^[\\w.-]+@([\\w-]+\\.)+\\w{2,}$";
        if (!email.matches(regex)) {
            throw new InvalidParameterException("Invalid e-mail!");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
