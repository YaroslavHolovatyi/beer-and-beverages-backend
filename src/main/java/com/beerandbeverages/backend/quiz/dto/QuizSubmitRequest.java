package com.beerandbeverages.backend.quiz.dto;

import java.util.Map;

public record QuizSubmitRequest(
        Map<Long, Long> answers, // questionId -> answerId
        String gender
) {}

