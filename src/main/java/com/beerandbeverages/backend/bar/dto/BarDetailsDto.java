package com.beerandbeverages.backend.bar.dto;

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
        Byte priceLevel,
        Double rating,
        Double latitude,
        Double longitude,
        Boolean isActive
) {}

