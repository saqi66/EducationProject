package com.example.educationapp.service;

import com.example.educationapp.dto.DepartmentDto;
import com.example.educationapp.dto.request.DepartmentRequest;
import com.example.educationapp.model.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto getDepartmentById(Long id);
    Department saveDepartment(DepartmentRequest departmentRequest);
    Department updateDepartment(DepartmentRequest departmentRequest);
    List<DepartmentDto> getAll();
    void deleteById(Long id);

}
