package com.beerandbeverages.backend.quiz.dto;

public record QuizAnswerDto(
        Long answerId,
        String key,
        String text
) {}
