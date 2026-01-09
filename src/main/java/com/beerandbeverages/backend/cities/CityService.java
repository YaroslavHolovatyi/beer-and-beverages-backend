package com.beerandbeverages.backend.cities;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll(Sort.by("name"));
    }

    // ✅ ADD THIS
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }
}
