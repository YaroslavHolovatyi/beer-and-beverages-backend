package com.beerandbeverages.backend.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "quiz_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    private Integer position;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<QuizAnswer> answers;
}


