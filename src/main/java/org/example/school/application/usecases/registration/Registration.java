package org.example.school.application.usecases.registration;

import org.example.school.application.usecases.registration.dto.StudentDto;
import org.example.school.domain.student.StudentRepository;
import org.example.school.domain.student.entity.Student;

public class Registration {
    public StudentRepository studentRepository;

    public Registration(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(StudentDto studentDto) {
        Student student = studentDto.toModel();
        this.studentRepository.matricula(student);
    }
}
