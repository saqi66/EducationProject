package com.example.educationapp.mapper;

import com.example.educationapp.dto.EduFormDto;
import com.example.educationapp.dto.request.EduFormRequest;
import com.example.educationapp.model.EduForm;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EduFormMapper {
    EduForm toEntity(EduFormRequest eduFormRequest);
    EduFormDto toDto(EduForm eduForm);
    EduForm toEntity(EduFormDto eduFormDto);
    List<EduFormDto> toDto(List<EduForm> eduForms);
    List<EduForm> toEntity(List<EduFormDto> eduFormDtos);
}

