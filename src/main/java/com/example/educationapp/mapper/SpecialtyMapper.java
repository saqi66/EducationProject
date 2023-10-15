package com.example.educationapp.mapper;

import com.example.educationapp.dto.SpecialtyDto;
import com.example.educationapp.dto.request.SpecialtyRequest;
import com.example.educationapp.model.Specialty;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {
    Specialty toEntity(SpecialtyRequest specialtyRequest);
    SpecialtyDto toDto(Specialty specialty);
    Specialty toEntity(SpecialtyDto specialtyDto);
    List<SpecialtyDto> toDto(List<Specialty> specialties);
    List<Specialty> toEntity(List<SpecialtyDto> specialtyDtos);

}
