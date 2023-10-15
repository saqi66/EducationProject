package com.example.educationapp.service;

import com.example.educationapp.dto.EduFormDto;
import com.example.educationapp.dto.request.EduFormRequest;
import com.example.educationapp.model.EduForm;

import java.util.List;

public interface EduFormService {

    EduFormDto getEduFormById(Long id);
    EduForm saveEduForm(EduFormRequest eduFormRequest);
    EduForm updateEduForm(EduFormRequest eduFormRequest);
    List<EduFormDto> getAll();
    void deleteById(Long id);

}
