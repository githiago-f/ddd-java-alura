package org.example.school;

import org.example.school.application.controller.StudentController;
import org.example.school.application.controller.dto.LoginDTO;
import org.example.school.application.usecases.registration.dto.StudentDto;
import org.example.school.infrastructure.utils.CreateTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        CreateTables createTables = new CreateTables(connection);
        createTables.createStudentsTable();

        StudentController studentController = new StudentController(connection);

        StudentDto studentDto = new StudentDto(
                "Thiago Farias",
                "thiago.farias@gmail.com",
                "000.000.000-00",
                "Senha123"
        );

        studentController.register(studentDto);

        LoginDTO loginDTO = new LoginDTO(
                "thiago.farias@gmail.com",
                "Senha123"
        );

        System.out.println(
                studentController.login(loginDTO)
        );
    }
}
