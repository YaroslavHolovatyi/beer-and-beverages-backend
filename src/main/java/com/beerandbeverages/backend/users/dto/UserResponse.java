package com.beerandbeverages.backend.users.dto;

import com.beerandbeverages.backend.cities.dto.CityResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String avatarUrl;
    private CityResponse mainCity;
}
