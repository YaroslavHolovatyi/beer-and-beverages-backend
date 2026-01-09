package com.beerandbeverages.backend.cities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class City {

    @Id
    private Long id;

    private String name;
    private String slug;

    private BigDecimal x;
    private BigDecimal y;
}

