package org.example.school.application.services;

import org.example.school.domain.student.entity.Student;

public interface SendRecommendationEmail {
    void sendTo(Student indicated);
}
