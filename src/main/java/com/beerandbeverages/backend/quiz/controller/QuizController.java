package com.beerandbeverages.backend.quiz.controller;

import com.beerandbeverages.backend.quiz.dto.QuizResultResponse;
import com.beerandbeverages.backend.quiz.dto.QuizSubmitRequest;
import com.beerandbeverages.backend.quiz.service.QuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizResultService quizResultService;

    @PostMapping("/submit")
    public QuizResultResponse submitQuiz(
            @RequestBody QuizSubmitRequest request
    ) {
        return quizResultService.calculateResult(request);
    }
}


