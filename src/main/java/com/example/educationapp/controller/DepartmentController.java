package com.example.educationapp.controller;

import com.example.educationapp.dto.DepartmentDto;
import com.example.educationapp.dto.request.DepartmentRequest;
import com.example.educationapp.model.Department;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(value = "/departmentList")
    public ResponseEntity<BaseResponse<List<DepartmentDto>>> getDepartmentInfo() {
        List<DepartmentDto> departmentDtos = departmentService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Department list successfully retrieved", departmentDtos));
    }

    @GetMapping(value = "/getDepartmentById/{id}")
    public ResponseEntity<BaseResponse<DepartmentDto>> getDepartmentById(@PathVariable(value = "id") Long id) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Department successfully retrieved", departmentDto));
    }

    @PostMapping(value = "/saveDepartment")
    public ResponseEntity<BaseResponse<Department>> saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
        Department department = departmentService.saveDepartment(departmentRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Department successfully saved", department));
    }

    @PutMapping(value = "/updateDepartment")
    public ResponseEntity<BaseResponse<Department>> updateDepartment(@RequestBody DepartmentRequest departmentRequest) {
        Department department = departmentService.updateDepartment(departmentRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Department successfully updated", department));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok("Department successfully deleted");
    }
}
