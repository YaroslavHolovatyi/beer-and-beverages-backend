package com.beerandbeverages.backend.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuizQuestion question;

    @Column(name = "answer_key")
    private String answerKey;

    @Column(name = "answer_text")
    private String answerText;
}
