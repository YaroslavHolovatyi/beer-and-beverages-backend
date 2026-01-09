package com.beerandbeverages.backend.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "races")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;
    private String name;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
}
