package com.beerandbeverages.backend.quiz.repository;

import com.beerandbeverages.backend.quiz.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAnswerRepository
        extends JpaRepository<QuizAnswer, Long> {
}
