package com.beerandbeverages.backend.bar.specs;


import com.beerandbeverages.backend.bar.entity.Bar;
import org.springframework.data.jpa.domain.Specification;

public final class BarSpecs {
    private BarSpecs() {}

    public static Specification<Bar> isActive(Boolean active) {
        if (active == null) return null;
        return (root, query, cb) -> cb.equal(root.get("isActive"), active);
    }

    public static Specification<Bar> cityId(Long cityId) {
        if (cityId == null) return null;
        return (root, query, cb) -> cb.equal(root.get("cityId"), cityId);
    }

    public static Specification<Bar> priceLevel(Integer priceLevel) {
        if (priceLevel == null) return null;
        return (root, query, cb) -> cb.equal(root.get("priceLevel"), priceLevel);
    }

    public static Specification<Bar> minRating(Double minRating) {
        if (minRating == null) return null;
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("rating"), minRating);
    }

    public static Specification<Bar> search(String q) {
        if (q == null || q.isBlank()) return null;
        String like = "%" + q.trim().toLowerCase() + "%";
        return (root, query, cb) -> cb.or(
                cb.like(cb.lower(root.get("name")), like),
                cb.like(cb.lower(root.get("address")), like)
        );
    }
}
