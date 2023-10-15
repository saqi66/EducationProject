package com.example.educationapp.service.impl;

import com.example.educationapp.dto.DepartmentDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.DepartmentRequest;
import com.example.educationapp.mapper.DepartmentMapper;
import com.example.educationapp.model.Department;
import com.example.educationapp.repository.DepartmentRepository;
import com.example.educationapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        log.info("Fetching department details for ID: {}", id);
        DepartmentDto result = mapper.toDto(
                departmentRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Department not found for ID: {}", id);
                            return new ResourceNotFoundException("Department", "id", id);
                        }));
        log.info("Successfully fetched department details for ID: {}", id);
        return result;
    }

    @Override
    public List<DepartmentDto> getAll() {
        log.info("Fetching all department details.");
        List<Department> departments = departmentRepository.findAll();
        log.info("Successfully fetched all department details.");
        return mapper.toDto(departments);
    }

    @Override
    public Department saveDepartment(DepartmentRequest departmentRequest) {
        log.info("Saving new department.");
        Department savedDepartment = departmentRepository.save(mapper.toEntity(departmentRequest));
        log.info("Successfully saved new department.");
        return savedDepartment;
    }

    @Override
    public Department updateDepartment(DepartmentRequest departmentRequest) {
        log.info("Updating department with ID: {}", departmentRequest.getId());
        if (!departmentRepository.existsById(departmentRequest.getId())) {
            log.error("Department not found for updating. ID: {}", departmentRequest.getId());
            throw new ResourceNotFoundException("Department", "Id not found", departmentRequest.getId());
        }
        Department updatedDepartment = departmentRepository.save(mapper.toEntity(departmentRequest));
        log.info("Successfully updated department with ID: {}", departmentRequest.getId());
        return updatedDepartment;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting department with ID: {}", id);
        if (!departmentRepository.existsById(id)) {
            log.error("Department not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Department", "Id not found", id);
        }
        departmentRepository.deleteById(id);
        log.info("Successfully deleted department with ID: {}", id);
    }
}
