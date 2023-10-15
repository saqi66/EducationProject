package com.example.educationapp.service;

import com.example.educationapp.dto.DisciplineDto;
import com.example.educationapp.dto.request.DisciplineRequest;
import com.example.educationapp.model.Discipline;

import java.util.List;

public interface DisciplineService {

    DisciplineDto getDisciplineById(Long id);
    Discipline saveDiscipline(DisciplineRequest disciplineRequest);
    Discipline updateDiscipline(DisciplineRequest disciplineRequest);
    List<DisciplineDto> getAll();
    void deleteById(Long id);

}
