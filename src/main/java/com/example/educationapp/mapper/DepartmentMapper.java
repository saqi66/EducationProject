package com.example.educationapp.mapper;

import com.example.educationapp.dto.DepartmentDto;
import com.example.educationapp.dto.request.DepartmentRequest;
import com.example.educationapp.model.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentRequest departmentRequest);
    DepartmentDto toDto(Department department);
    Department toEntity(DepartmentDto departmentDto);
    List<DepartmentDto> toDto(List<Department> departments);
    List<Department> toEntity(List<DepartmentDto> departmentDtos);

}
