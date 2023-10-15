package com.example.educationapp.controller;

import com.example.educationapp.dto.FacultyDto;
import com.example.educationapp.dto.request.FacultyRequest;
import com.example.educationapp.model.Faculty;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping(value = "/facultyList")
    public ResponseEntity<BaseResponse<List<FacultyDto>>> getFacultyInfo() {
        List<FacultyDto> facultyDtos = facultyService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Faculty list successfully retrieved", facultyDtos));
    }

    @GetMapping(value = "/getFacultyById/{id}")
    public ResponseEntity<BaseResponse<FacultyDto>> getFacultyById(@PathVariable(value = "id") Long id) {
        FacultyDto facultyDto = facultyService.getFacultyById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Faculty successfully retrieved", facultyDto));
    }

    @PostMapping(value = "/saveFaculty")
    public ResponseEntity<BaseResponse<Faculty>> saveFaculty(@RequestBody FacultyRequest facultyRequest) {
        Faculty faculty = facultyService.saveFaculty(facultyRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Faculty successfully saved", faculty));
    }

    @PutMapping(value = "/updateFaculty")
    public ResponseEntity<BaseResponse<Faculty>> updateFaculty(@RequestBody FacultyRequest facultyRequest) {
        Faculty faculty = facultyService.updateFaculty(facultyRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Faculty successfully updated", faculty));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        facultyService.deleteById(id);
        return ResponseEntity.ok("Faculty successfully deleted");
    }
}