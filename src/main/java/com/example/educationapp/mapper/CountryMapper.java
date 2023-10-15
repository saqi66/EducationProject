package com.example.educationapp.mapper;

import com.example.educationapp.dto.CountryDto;
import com.example.educationapp.dto.request.CountryRequest;
import com.example.educationapp.model.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryRequest countryRequest);
    CountryDto toDto(Country country);
    Country toEntity(CountryDto countryDto);
    List<CountryDto> toDto(List<Country> countries);
    List<Country> toEntity(List<CountryDto> countryDtos);

}
