package com.beerandbeverages.backend.bar.controller;

import com.beerandbeverages.backend.bar.dto.BarDetailsDto;
import com.beerandbeverages.backend.bar.dto.BarListItemDto;
import com.beerandbeverages.backend.bar.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bars")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;

    // ✅ Bars list page
    @GetMapping
    public Page<BarListItemDto> getBars(
            @RequestParam(required = false) Long cityId,
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Integer priceLevel,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Boolean active,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "rating") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDir
    ) {
        return barService.getBars(
                cityId, q, priceLevel, minRating, active,
                page, size, sortBy, sortDir
        );
    }

    // ✅ Bar page (THIS is what you asked about)
    @GetMapping("/{slug}")
    public BarDetailsDto getBar(@PathVariable String slug) {
        return barService.getBarBySlug(slug);
    }
}
