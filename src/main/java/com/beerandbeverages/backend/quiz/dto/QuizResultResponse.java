package com.beerandbeverages.backend.quiz.dto;

import com.beerandbeverages.backend.quiz.entity.QuizAnswerRace;

import java.util.HashMap;
import java.util.Map;

public record QuizResultResponse(
        Long raceId,
        String slug,
        String title,
        String description,
        Map<Long, Integer> scoreTable
) {}

