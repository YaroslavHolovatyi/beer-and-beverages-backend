package com.beerandbeverages.backend.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "quiz_answer_races")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswerRace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private QuizAnswer answer;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    private Integer score;
}


