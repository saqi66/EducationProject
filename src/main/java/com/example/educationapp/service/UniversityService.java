package com.example.educationapp.service;

import com.example.educationapp.dto.UniversityDto;
import com.example.educationapp.dto.request.UniversityRequest;
import com.example.educationapp.model.University;

import java.util.List;

public interface UniversityService {

    UniversityDto getUniversityById(Long id);
    University saveUniversity(UniversityRequest universityRequest);
    University updateUniversity(UniversityRequest universityRequest);
    List<UniversityDto> getAll();
    void deleteById(Long id);

}
