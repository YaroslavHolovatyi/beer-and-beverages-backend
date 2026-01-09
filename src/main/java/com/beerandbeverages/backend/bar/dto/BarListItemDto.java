package com.beerandbeverages.backend.bar.dto;

public record BarListItemDto(
        String slug,
        Long cityId,
        String name,
        String address,
        Byte priceLevel,
        Double rating,
        Double latitude,
        Double longitude
) {}

