package com.example.educationapp.mapper;

import com.example.educationapp.dto.UniversityDto;
import com.example.educationapp.dto.request.UniversityRequest;
import com.example.educationapp.model.University;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversityMapper {
    University toEntity(UniversityRequest universityRequest);
    UniversityDto toDto(University university);
    University toEntity(UniversityDto universityDto);
    List<UniversityDto> toDto(List<University> universities);
    List<University> toEntity(List<UniversityDto> universityDtos);

}
