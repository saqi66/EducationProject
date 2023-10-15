package com.example.educationapp.mapper;

import com.example.educationapp.dto.CityDto;
import com.example.educationapp.dto.request.CityRequest;
import com.example.educationapp.model.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityRequest cityRequest);
    CityDto toDto(City city);
    City toEntity(CityDto cityDto);
    List<CityDto> toDto(List<City> cities);
    List<City> toEntity(List<CityDto> cityDtos);

}
