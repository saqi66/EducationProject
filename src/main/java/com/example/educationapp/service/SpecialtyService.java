package com.example.educationapp.service;

import com.example.educationapp.dto.SpecialtyDto;
import com.example.educationapp.dto.request.SpecialtyRequest;
import com.example.educationapp.model.Specialty;

import java.util.List;

public interface SpecialtyService {

    SpecialtyDto getSpecialtyById(Long id);
    Specialty saveSpecialty(SpecialtyRequest specialtyRequest);
    Specialty updateSpecialty(SpecialtyRequest specialtyRequest);
    List<SpecialtyDto> getAll();
    void deleteById(Long id);

}
