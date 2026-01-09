package com.beerandbeverages.backend.quiz.dto;

import java.util.List;

public record QuizQuestionDto(
        Integer id,
        String question,
        List<QuizAnswerDto> options
) {}

