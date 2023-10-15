package com.example.educationapp.controller;

import com.example.educationapp.dto.UniversityDto;
import com.example.educationapp.dto.request.UniversityRequest;
import com.example.educationapp.model.University;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/university")
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping(value = "/universityList")
    public ResponseEntity<BaseResponse<List<UniversityDto>>> getUniversityInfo() {
        List<UniversityDto> universityDtos = universityService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "University list successfully retrieved", universityDtos));
    }

    @GetMapping(value = "/getUniversityById/{id}")
    public ResponseEntity<BaseResponse<UniversityDto>> getUniversityById(@PathVariable(value = "id") Long id) {
        UniversityDto universityDto = universityService.getUniversityById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "University successfully retrieved", universityDto));
    }

    @PostMapping(value = "/saveUniversity")
    public ResponseEntity<BaseResponse<University>> saveUniversity(@RequestBody UniversityRequest universityRequest) {
        University university = universityService.saveUniversity(universityRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "University successfully saved", university));
    }

    @PutMapping(value = "/updateUniversity")
    public ResponseEntity<BaseResponse<University>> updateUniversity(@RequestBody UniversityRequest universityRequest) {
        University university = universityService.updateUniversity(universityRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "University successfully updated", university));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        universityService.deleteById(id);
        return ResponseEntity.ok("University successfully deleted");
    }
}
