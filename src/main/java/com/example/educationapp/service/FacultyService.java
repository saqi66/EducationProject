package com.example.educationapp.service;

import com.example.educationapp.dto.FacultyDto;
import com.example.educationapp.dto.request.FacultyRequest;
import com.example.educationapp.model.Faculty;

import java.util.List;

public interface FacultyService {

    FacultyDto getFacultyById(Long id);
    Faculty saveFaculty(FacultyRequest facultyRequest);
    Faculty updateFaculty(FacultyRequest facultyRequest);
    List<FacultyDto> getAll();
    void deleteById(Long id);

}
