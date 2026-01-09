package com.beerandbeverages.backend.quiz.repository;

import com.beerandbeverages.backend.quiz.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
