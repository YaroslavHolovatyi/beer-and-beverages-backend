package com.beerandbeverages.backend.users.mapper;

import com.beerandbeverages.backend.users.dto.UserResponse;
import com.beerandbeverages.backend.users.entity.User;
import com.beerandbeverages.backend.cities.dto.CityResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setAvatarUrl(user.getAvatarUrl());

        if (user.getMainCity() != null) {
            dto.setMainCity(
                    new CityResponse(
                            user.getMainCity().getId(),
                            user.getMainCity().getName(),
                            user.getMainCity().getSlug()
                    )
            );
        }

        return dto;
    }
}

