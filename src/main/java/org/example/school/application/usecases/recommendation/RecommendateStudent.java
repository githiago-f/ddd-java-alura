package org.example.school.application.usecases.recommendation;

import org.example.school.application.services.SendRecommendationEmail;
import org.example.school.domain.recommendation.Recommendation;
import org.example.school.domain.recommendation.RecommendationRepository;
import org.example.school.domain.student.StudentRepository;
import org.example.school.domain.student.entity.Student;

public class RecommendateStudent {
    private final RecommendationRepository recommendationRepository;
    private final StudentRepository studentRepository;

    public RecommendateStudent(RecommendationRepository recommendationRepository, StudentRepository studentRepository) {
        this.recommendationRepository = recommendationRepository;
        this.studentRepository = studentRepository;
    }

    public void execute(String indicatorCpf, String indicatedCpf) {
        Student indicator = studentRepository.findByCpf(indicatorCpf);
        Student indicated = studentRepository.findByCpf(indicatedCpf);

        Recommendation recommendation = new Recommendation(indicator, indicated);

        SendRecommendationEmail indicacao = student -> {};
        indicacao.sendTo(indicated);

        recommendationRepository.recommend(recommendation);
    }
}
