package org.example.school.domain.student.services;

public interface PasswordCipherStrategy {
    String parse(String password);
    boolean correspondsTo(String password, String encryptedPassword);
}
