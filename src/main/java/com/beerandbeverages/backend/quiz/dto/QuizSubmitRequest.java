package com.beerandbeverages.backend.quiz.dto;

import java.util.Map;

public record QuizSubmitRequest(
        Map<Integer, Integer> answers,
        String gender
) {}


