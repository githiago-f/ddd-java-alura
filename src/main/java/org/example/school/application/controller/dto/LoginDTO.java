package org.example.school.application.controller.dto;

public class LoginDTO {
    public final String email;
    public final String password;

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
