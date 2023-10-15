package com.example.educationapp.service.impl;

import com.example.educationapp.dto.CountryDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.CountryRequest;
import com.example.educationapp.mapper.CountryMapper;
import com.example.educationapp.model.Country;
import com.example.educationapp.repository.CountryRepository;
import com.example.educationapp.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    @Override
    public CountryDto getCountryById(Long id) {
        log.info("Fetching country details for ID: {}", id);
        CountryDto result = mapper.toDto(
                countryRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Country not found for ID: {}", id);
                            return new ResourceNotFoundException("Country", "id", id);
                        }));
        log.info("Successfully fetched country details for ID: {}", id);
        return result;
    }

    @Override
    public List<CountryDto> getAll() {
        log.info("Fetching all country details.");
        List<Country> countries = countryRepository.findAll();
        log.info("Successfully fetched all country details.");
        return mapper.toDto(countries);
    }

    @Override
    public Country saveCountry(CountryRequest countryRequest) {
        log.info("Saving new country.");
        Country savedCountry = countryRepository.save(mapper.toEntity(countryRequest));
        log.info("Successfully saved new country with ID: {}", savedCountry.getId());
        return savedCountry;
    }

    @Override
    public Country updateCountry(CountryRequest countryRequest) {
        log.info("Updating country with ID: {}", countryRequest.getId());
        if (!countryRepository.existsById(countryRequest.getId())) {
            log.error("Country not found for updating. ID: {}", countryRequest.getId());
            throw new ResourceNotFoundException("Country", "Id not found", countryRequest.getId());
        }
        Country updatedCountry = countryRepository.save(mapper.toEntity(countryRequest));
        log.info("Successfully updated country with ID: {}", updatedCountry.getId());
        return updatedCountry;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting country with ID: {}", id);
        if (!countryRepository.existsById(id)) {
            log.error("Country not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Country", "Id not found", id);
        }
        countryRepository.deleteById(id);
        log.info("Successfully deleted country with ID: {}", id);
    }
}
