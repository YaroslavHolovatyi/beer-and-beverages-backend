package com.beerandbeverages.backend.quiz.dto;

public record QuizAnswerDto(
        Integer answerId,
        String key,
        String text
) {}
