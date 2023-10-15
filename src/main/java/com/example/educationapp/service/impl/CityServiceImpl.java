package com.example.educationapp.service.impl;

import com.example.educationapp.dto.CityDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.CityRequest;
import com.example.educationapp.mapper.CityMapper;
import com.example.educationapp.model.City;
import com.example.educationapp.repository.CityRepository;
import com.example.educationapp.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper mapper;

    @Override
    public CityDto getCityById(Long id) {
        log.info("Fetching city details for ID: {}", id);
        CityDto result = mapper.toDto(
                cityRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("City not found for ID: {}", id);
                            return new ResourceNotFoundException("City", "id", id);
                        }));
        log.info("Successfully fetched city details for ID: {}", id);
        return result;
    }

    @Override
    public List<CityDto> getAll() {
        log.info("Fetching all city details.");
        List<City> cities = cityRepository.findAll();
        log.info("Successfully fetched all city details.");
        return mapper.toDto(cities);
    }

    @Override
    public City saveCity(CityRequest cityRequest) {
        log.info("Saving new city.");
        City savedCity = cityRepository.save(mapper.toEntity(cityRequest));
        log.info("Successfully saved new city.");
        return savedCity;
    }

    @Override
    public City updateCity(CityRequest cityRequest) {
        log.info("Updating city with ID: {}", cityRequest.getId());
        if (!cityRepository.existsById(cityRequest.getId())) {
            log.error("City not found for updating. ID: {}", cityRequest.getId());
            throw new ResourceNotFoundException("City", "Id not found", cityRequest.getId());
        }
        City updatedCity = cityRepository.save(mapper.toEntity(cityRequest));
        log.info("Successfully updated city with ID: {}", cityRequest.getId());
        return updatedCity;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting city with ID: {}", id);
        if (!cityRepository.existsById(id)) {
            log.error("City not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("City", "Id not found", id);
        }
        cityRepository.deleteById(id);
        log.info("Successfully deleted city with ID: {}", id);
    }
}
