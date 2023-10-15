package com.example.educationapp.service;

import com.example.educationapp.dto.ScienDegreeDto;
import com.example.educationapp.dto.request.ScienDegreeRequest;
import com.example.educationapp.model.ScienDegree;

import java.util.List;

public interface ScienDegreeService {

    ScienDegreeDto getScienDegreeById(Long id);
    ScienDegree saveScienDegree(ScienDegreeRequest scienDegreeRequest);
    ScienDegree updateScienDegree(ScienDegreeRequest scienDegreeRequest);
    List<ScienDegreeDto> getAll();
    void deleteById(Long id);

}
