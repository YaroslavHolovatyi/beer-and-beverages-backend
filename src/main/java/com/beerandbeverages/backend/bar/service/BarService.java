package com.beerandbeverages.backend.bar.service;

import com.beerandbeverages.backend.bar.dto.BarDetailsDto;
import com.beerandbeverages.backend.bar.dto.BarListItemDto;
import com.beerandbeverages.backend.bar.entity.Bar;
import com.beerandbeverages.backend.bar.repository.BarRepository;
import com.beerandbeverages.backend.bar.specs.BarSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BarService {

    private final BarRepository barRepository;

    public Page<BarListItemDto> getBars(
            Long cityId,
            String q,
            Integer priceLevel,
            Double minRating,
            Boolean active,
            int page,
            int size,
            String sortBy,
            String sortDir
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Bar> spec = Specification
                .where(BarSpecs.cityId(cityId))
                .and(BarSpecs.search(q))
                .and(BarSpecs.priceLevel(priceLevel))
                .and(BarSpecs.minRating(minRating))
                .and(BarSpecs.isActive(active));

        return barRepository.findAll(spec, pageable)
                .map(b -> new BarListItemDto(
                        b.getSlug(),
                        b.getCityId(),
                        b.getName(),
                        b.getAddress(),
                        b.getPriceLevel(),
                        b.getRating() != null ? b.getRating().doubleValue() : null,
                        b.getLatitude() != null ? b.getLatitude().doubleValue() : null,
                        b.getLongitude() != null ? b.getLongitude().doubleValue() : null
                ));

    }

    public BarDetailsDto getBarBySlug(String slug) {
        Bar b = barRepository.findById(slug)
                .orElseThrow(() -> new EntityNotFoundException("Bar not found: " + slug));

        return new BarDetailsDto(
                b.getSlug(),
                b.getCityId(),
                b.getName(),
                b.getAddress(),
                b.getDescription(),
                b.getPhone(),
                b.getMenuUrl(),
                b.getSiteUrl(),
                b.getWebsiteUrl(),
                b.getPriceLevel(),

                b.getRating() != null ? b.getRating().doubleValue() : null,
                b.getLatitude() != null ? b.getLatitude().doubleValue() : null,
                b.getLongitude() != null ? b.getLongitude().doubleValue() : null,

                b.getIsActive()
        );

    }
}
