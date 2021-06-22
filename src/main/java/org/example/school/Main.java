package org.example.school;

import org.example.school.domain.student.StudentRepository;
import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.StudentBuilder;
import org.example.school.infraestrutura.DAL.JDBC.StudentRepositoryJDBC;
import org.example.school.infraestrutura.utils.CreateTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        StudentRepository studentRepository = new StudentRepositoryJDBC(connection);

        CreateTables createTables = new CreateTables(connection);
        createTables.createStudents();

        Student student = new StudentBuilder()
                    .withName("Thiago Farias")
                    .withEmail("thiago.farias@gmail.com")
                    .withCpf("000.000.000-00")
                    .withPassword("Senha123")
                    .build();

        studentRepository.matricula(student);

        Student fromSqlite = studentRepository.buscaPorCpf("000.000.000-00");

        System.out.println(fromSqlite.getName());
    }
}
