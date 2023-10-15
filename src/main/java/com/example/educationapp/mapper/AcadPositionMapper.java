package com.example.educationapp.mapper;

import com.example.educationapp.dto.AcadPositionDto;
import com.example.educationapp.dto.request.AcadPositionRequest;
import com.example.educationapp.model.AcadPosition;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")

public interface AcadPositionMapper {

    AcadPosition toEntity(AcadPositionRequest acadPositionRequest);

    AcadPositionDto toDto(AcadPosition acadPosition);

    AcadPosition toEntity(AcadPositionDto acadPositionDto);

    List<AcadPositionDto> toDto(List<AcadPosition> acadPositions);

    List<AcadPosition> toEntity(List<AcadPositionDto> acadPositionDtos);

}
