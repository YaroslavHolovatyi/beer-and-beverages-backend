package com.beerandbeverages.backend.quiz.dto;

import java.util.List;

public record QuizQuestionDto(
        Long id,
        String question,
        List<QuizAnswerDto> options
) {}

