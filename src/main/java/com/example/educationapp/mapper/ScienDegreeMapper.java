package com.example.educationapp.mapper;

import com.example.educationapp.dto.ScienDegreeDto;
import com.example.educationapp.dto.request.ScienDegreeRequest;
import com.example.educationapp.model.ScienDegree;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScienDegreeMapper {
    ScienDegree toEntity(ScienDegreeRequest scienDegreeRequest);
    ScienDegreeDto toDto(ScienDegree scienDegree);
    ScienDegree toEntity(ScienDegreeDto scienDegreeDto);
    List<ScienDegreeDto> toDto(List<ScienDegree> scienDegrees);
    List<ScienDegree> toEntity(List<ScienDegreeDto> scienDegreeDtos);

}
