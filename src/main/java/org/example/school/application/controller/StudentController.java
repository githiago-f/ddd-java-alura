package org.example.school.application.controller;

import org.example.school.application.controller.dto.LoginDTO;
import org.example.school.application.usecases.registration.Registration;
import org.example.school.application.usecases.registration.dto.StudentDto;
import org.example.school.domain.student.StudentRepository;
import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.services.PasswordCipherStrategy;
import org.example.school.infrastructure.Cipher.PasswordCipherMD5;
import org.example.school.infrastructure.DAL.JDBC.StudentRepositoryJDBC;

import java.sql.Connection;

public class StudentController {
    private final StudentRepository studentRepository;
    private final PasswordCipherStrategy cipher = new PasswordCipherMD5();

    public StudentController(Connection connection) {
        studentRepository = new StudentRepositoryJDBC(connection);
    }

    // TODO: add controller annotations
    public void register(StudentDto studentDto) {
        Registration registration = new Registration(studentRepository, cipher);
        registration.execute(studentDto);
    }

    public Student login(LoginDTO loginDTO) {
        Student student = studentRepository.findByEmail(loginDTO.email);
        if(student.getPassword().equals(loginDTO.password)) {
            return student;
        }
        return null;
    }
}
