package com.beerandbeverages.backend.quiz.entity;

import java.io.Serializable;
import java.util.Objects;

public class QuizAnswerRaceId implements Serializable {

    private Integer answer;
    private Integer race;

    public QuizAnswerRaceId() {
    }

    public QuizAnswerRaceId(Integer answer, Integer race) {
        this.answer = answer;
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuizAnswerRaceId that)) return false;
        return Objects.equals(answer, that.answer)
                && Objects.equals(race, that.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, race);
    }
}

