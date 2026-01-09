package com.beerandbeverages.backend.quiz.repository;

import com.beerandbeverages.backend.quiz.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizQuestionRepository
        extends JpaRepository<QuizQuestion, Long> {

    List<QuizQuestion> findAllByOrderByPositionAsc();
}
