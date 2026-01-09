package com.beerandbeverages.backend.bar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bars")
public class Bar {

    @Id
    @Column(name = "slug", length = 255, nullable = false)
    private String slug;

    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "address", nullable = false, length = 500)
    private String address;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "menu_url", length = 255)
    private String menuUrl;

    @Column(name = "site_url", length = 255)
    private String siteUrl;

    @Column(name = "website_url", length = 500)
    private String websiteUrl;

    @Column(name = "price_level")
    private Integer priceLevel; // TINYINT -> Integer is OK

    @Column(name = "rating", precision = 4, scale = 2)
    private BigDecimal rating;

    @Column(name = "latitude", precision = 11, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 11, scale = 6)
    private BigDecimal longitude;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

