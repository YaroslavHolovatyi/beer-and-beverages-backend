package com.beerandbeverages.backend.cities;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return cityService.findAll();
    }
}

