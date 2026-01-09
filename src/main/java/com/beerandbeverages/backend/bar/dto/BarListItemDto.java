package com.beerandbeverages.backend.bar.dto;

import java.math.BigDecimal;

public record BarListItemDto(
        String slug,
        Long cityId,
        String name,
        String address,
        Integer priceLevel,
        BigDecimal rating,
        BigDecimal latitude,
        BigDecimal longitude
) {}
