package org.example.school.application.usecases.registration;

import org.example.school.application.usecases.registration.dto.StudentDto;
import org.example.school.domain.student.StudentRepository;
import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.services.PasswordCipherStrategy;

public class Registration {
    private final StudentRepository studentRepository;
    private final PasswordCipherStrategy cipher;

    public Registration(StudentRepository studentRepository, PasswordCipherStrategy cipher) {
        this.studentRepository = studentRepository;
        this.cipher = cipher;
    }

    public void execute(StudentDto studentDto) {
        studentDto.password = cipher.parse(studentDto.password);
        Student student = studentDto.toModel();
        this.studentRepository.register(student);
    }
}
