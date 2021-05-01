package org.example.school.application.service;

import org.example.school.domain.student.entity.Student;

public interface SendRecommendationEmail {
    void sendTo(Student indicated);
}
