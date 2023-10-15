package com.example.educationapp.mapper;

import com.example.educationapp.dto.SpecialtyEduFormDto;
import com.example.educationapp.dto.request.SpecialtyEduFormRequest;
import com.example.educationapp.model.SpecialtyEduForm;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyEduFormMapper {
    SpecialtyEduForm toEntity(SpecialtyEduFormRequest specialtyEduFormRequest);
    SpecialtyEduFormDto toDto(SpecialtyEduForm specialtyEduForm);
    SpecialtyEduForm toEntity(SpecialtyEduFormDto specialtyEduFormDto);
    List<SpecialtyEduFormDto> toDto(List<SpecialtyEduForm> specialtyEduForms);
    List<SpecialtyEduForm> toEntity(List<SpecialtyEduFormDto> specialtyEduFormDtos);

}
