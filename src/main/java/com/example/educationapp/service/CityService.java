package com.example.educationapp.service;

import com.example.educationapp.dto.CityDto;
import com.example.educationapp.dto.request.CityRequest;
import com.example.educationapp.model.City;

import java.util.List;

public interface CityService {

    CityDto getCityById(Long id);
    City saveCity(CityRequest cityRequest);
    City updateCity(CityRequest cityRequest);
    List<CityDto> getAll();
    void deleteById(Long id);

}
