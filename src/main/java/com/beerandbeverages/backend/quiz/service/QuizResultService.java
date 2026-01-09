package com.beerandbeverages.backend.quiz.service;

import com.beerandbeverages.backend.quiz.dto.QuizResultResponse;
import com.beerandbeverages.backend.quiz.dto.QuizSubmitRequest;
import com.beerandbeverages.backend.quiz.entity.QuizAnswerRace;
import com.beerandbeverages.backend.quiz.entity.Race;
import com.beerandbeverages.backend.quiz.repository.QuizAnswerRaceRepository;
import com.beerandbeverages.backend.quiz.repository.RaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuizResultService {

    private final QuizAnswerRaceRepository answerRaceRepository;
    private final RaceRepository raceRepository;

    public QuizResultResponse calculateResult(QuizSubmitRequest request) {

        Map<Long, Integer> raceScores = new HashMap<>();

        for (Long answerId : request.answers().values()) {
            List<QuizAnswerRace> mappings =
                    answerRaceRepository.findByAnswerId(answerId);

            for (QuizAnswerRace ar : mappings) {
                raceScores.merge(
                        ar.getRace().getId(),
                        ar.getScore(),
                        Integer::sum
                );
            }
        }

        Long winningRaceId = raceScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() ->
                        new IllegalStateException("No race calculated")
                )
                .getKey();

        Race race = raceRepository.findById(winningRaceId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Race not found: " + winningRaceId)
                );

        return new QuizResultResponse(
                race.getId(),
                race.getSlug(),
                race.getTitle(),
                race.getDescription(),
                raceScores
        );
    }
}
