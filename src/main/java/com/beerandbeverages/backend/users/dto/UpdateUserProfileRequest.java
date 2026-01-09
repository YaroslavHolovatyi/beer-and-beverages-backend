package com.beerandbeverages.backend.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserProfileRequest {

    @NotBlank
    private String firstName;

    private String lastName;

    private String username;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Long mainCityId;
}
