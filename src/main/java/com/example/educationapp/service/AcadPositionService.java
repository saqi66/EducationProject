package com.example.educationapp.service;

import com.example.educationapp.dto.AcadPositionDto;
import com.example.educationapp.dto.request.AcadPositionRequest;
import com.example.educationapp.model.AcadPosition;

import java.util.List;

public interface AcadPositionService {

    AcadPositionDto getAcadPositionById(Long id);

    AcadPosition saveAcadPosition (AcadPositionRequest acadPositionRequest);

    AcadPosition updateAcadPosition (AcadPositionRequest acadPositionRequest);

    List<AcadPositionDto> getAll();

    void deleteById(Long id);

}
