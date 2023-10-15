package com.example.educationapp.service;

import com.example.educationapp.dto.SpecialtyEduFormDto;
import com.example.educationapp.dto.request.SpecialtyEduFormRequest;
import com.example.educationapp.model.SpecialtyEduForm;

import java.util.List;

public interface SpecialtyEduFormService {

    SpecialtyEduFormDto getSpecialtyEduFormById(Long id);
    SpecialtyEduForm saveSpecialtyEduForm(SpecialtyEduFormRequest specialtyEduFormRequest);
    SpecialtyEduForm updateSpecialtyEduForm(SpecialtyEduFormRequest specialtyEduFormRequest);
    List<SpecialtyEduFormDto> getAll();
    void deleteById(Long id);

}
