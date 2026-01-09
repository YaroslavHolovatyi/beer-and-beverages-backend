package com.beerandbeverages.backend.quiz.repository;

import com.beerandbeverages.backend.quiz.entity.QuizAnswerRace;
import com.beerandbeverages.backend.quiz.entity.QuizAnswerRaceId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAnswerRaceRepository
        extends JpaRepository<QuizAnswerRace, QuizAnswerRaceId> {

    List<QuizAnswerRace> findByAnswer_Id(Integer answerId);

}

