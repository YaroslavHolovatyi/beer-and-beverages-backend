package com.beerandbeverages.backend.auth;

import com.beerandbeverages.backend.auth.dto.LoginRequest;
import com.beerandbeverages.backend.auth.dto.RegisterRequest;
import com.beerandbeverages.backend.cities.City;
import com.beerandbeverages.backend.cities.CityRepository;
import com.beerandbeverages.backend.users.entity.User;
import com.beerandbeverages.backend.users.entity.UserRole;
import com.beerandbeverages.backend.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final CityRepository cityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserService userService,
            CityRepository cityRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userService = userService;
        this.cityRepository = cityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {

        if (userService.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        City city = cityRepository.findById(request.getMainCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        User user = new User();
        user.setEmail(request.getEmail().toLowerCase());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(UserRole.USER);
        user.setIsActive(true);
        user.setMainCity(city);
        user.setPasswordHash(
                passwordEncoder.encode(request.getPassword())
        );

        userService.save(user);

        return ResponseEntity.ok("User registered");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {

        var userOpt = userService.findByEmail(request.getEmail().toLowerCase());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        var user = userOpt.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok("Login successful");
    }



}
