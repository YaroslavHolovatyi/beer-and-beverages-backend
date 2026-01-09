package com.beerandbeverages.backend.quiz.repository;

import com.beerandbeverages.backend.quiz.entity.QuizAnswerRace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAnswerRaceRepository
        extends JpaRepository<QuizAnswerRace, Long> {

    List<QuizAnswerRace> findByAnswerId(Long answerId);
}

