package com.beerandbeverages.backend.users.controller;

import com.beerandbeverages.backend.cities.City;
import com.beerandbeverages.backend.cities.CityService;
import com.beerandbeverages.backend.users.dto.UpdateUserProfileRequest;
import com.beerandbeverages.backend.users.dto.UserResponse;
import com.beerandbeverages.backend.users.entity.User;
import com.beerandbeverages.backend.users.mapper.UserMapper;
import com.beerandbeverages.backend.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final CityService cityService;
    private final UserMapper userMapper;

    public UserController(
            UserService userService,
            CityService cityService,
            UserMapper userMapper
    ) {
        this.userService = userService;
        this.cityService = cityService;
        this.userMapper = userMapper;
    }

    /**
     * Update current user's profile
     * Used by: Edit Profile page (Angular)
     */
    @PutMapping("/me")
    public UserResponse updateProfile(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid UpdateUserProfileRequest request
    ) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }

        // === Uniqueness checks ===
        if (userService.emailExistsForOtherUser(request.getEmail(), user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already used by another user"
            );
        }

        if (
                request.getUsername() != null &&
                        userService.usernameExistsForOtherUser(request.getUsername(), user.getId())
        ) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username is already used by another user"
            );
        }

        // === Load city ===
        City city = cityService.findById(request.getMainCityId())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "City not found"
                        )
                );

        // === Apply updates ===
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setMainCity(city);

        User savedUser = userService.save(user);

        return userMapper.toResponse(savedUser);
    }

    /**
     * Get current user profile
     * Useful for profile page & refresh after update
     */
    @GetMapping("/me")
    public UserResponse getCurrentUser(
            @AuthenticationPrincipal User user
    ) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }

        return userMapper.toResponse(user);
    }
}
