package com.beerandbeverages.backend.quiz.service;

import com.beerandbeverages.backend.quiz.dto.QuizAnswerDto;
import com.beerandbeverages.backend.quiz.dto.QuizQuestionDto;
import com.beerandbeverages.backend.quiz.dto.QuizResultResponse;
import com.beerandbeverages.backend.quiz.dto.QuizSubmitRequest;
import com.beerandbeverages.backend.quiz.entity.QuizAnswerRace;
import com.beerandbeverages.backend.quiz.repository.QuizAnswerRaceRepository;
import com.beerandbeverages.backend.quiz.repository.QuizQuestionRepository;
import com.beerandbeverages.backend.quiz.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizQuestionRepository questionRepository;
    private final QuizAnswerRaceRepository answerRaceRepository;

    public List<QuizQuestionDto> getQuizQuestions() {
        return questionRepository.findAllByOrderByPositionAsc()
                .stream()
                .map(q -> new QuizQuestionDto(
                        q.getId(),
                        q.getQuestionText(),
                        q.getAnswers().stream()
                                .map(a -> new QuizAnswerDto(
                                        a.getId(),
                                        a.getAnswerKey(),
                                        a.getAnswerText()
                                ))
                                .toList()
                ))
                .toList();
    }
}


