package com.beerandbeverages.backend.bar.dto;

import java.math.BigDecimal;

public record BarDetailsDto(
        String slug,
        Long cityId,
        String name,
        String address,
        String description,
        String phone,
        String menuUrl,
        String siteUrl,
        String websiteUrl,
        Integer priceLevel,
        BigDecimal rating,
        BigDecimal latitude,
        BigDecimal longitude,
        Boolean isActive
) {}
