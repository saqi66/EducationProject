package com.example.educationapp.mapper;

import com.example.educationapp.dto.DisciplineDto;
import com.example.educationapp.dto.request.DisciplineRequest;
import com.example.educationapp.model.Discipline;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {
    Discipline toEntity(DisciplineRequest disciplineRequest);
    DisciplineDto toDto(Discipline discipline);
    Discipline toEntity(DisciplineDto disciplineDto);
    List<DisciplineDto> toDto(List<Discipline> disciplines);
    List<Discipline> toEntity(List<DisciplineDto> disciplineDtos);

}
