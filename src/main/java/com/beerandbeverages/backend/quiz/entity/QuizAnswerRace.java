package com.beerandbeverages.backend.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quiz_answer_races")
@IdClass(QuizAnswerRaceId.class)
@Getter
@Setter
public class QuizAnswerRace {

    @Id
    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private QuizAnswer answer;

    @Id
    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Column(nullable = false)
    private Integer score;
}


