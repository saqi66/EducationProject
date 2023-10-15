package com.example.educationapp.service;

import com.example.educationapp.dto.CountryDto;
import com.example.educationapp.dto.request.CountryRequest;
import com.example.educationapp.model.Country;

import java.util.List;

public interface CountryService {

    CountryDto getCountryById(Long id);
    Country saveCountry(CountryRequest countryRequest);
    Country updateCountry(CountryRequest countryRequest);
    List<CountryDto> getAll();
    void deleteById(Long id);

}
