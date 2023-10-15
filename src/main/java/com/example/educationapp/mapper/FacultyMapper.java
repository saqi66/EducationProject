package com.example.educationapp.mapper;

import com.example.educationapp.dto.FacultyDto;
import com.example.educationapp.dto.request.FacultyRequest;
import com.example.educationapp.model.Faculty;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    Faculty toEntity(FacultyRequest facultyRequest);
    FacultyDto toDto(Faculty faculty);
    Faculty toEntity(FacultyDto facultyDto);
    List<FacultyDto> toDto(List<Faculty> faculties);
    List<Faculty> toEntity(List<FacultyDto> facultyDtos);

}
