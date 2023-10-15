package com.example.educationapp.controller;

import com.example.educationapp.dto.SpecialtyDto;
import com.example.educationapp.dto.request.SpecialtyRequest;
import com.example.educationapp.model.Specialty;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @GetMapping(value = "/specialtyList")
    public ResponseEntity<BaseResponse<List<SpecialtyDto>>> getSpecialtyInfo() {
        List<SpecialtyDto> specialtyDtos = specialtyService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Specialty list successfully retrieved", specialtyDtos));
    }

    @GetMapping(value = "/getSpecialtyById/{id}")
    public ResponseEntity<BaseResponse<SpecialtyDto>> getSpecialtyById(@PathVariable(value = "id") Long id) {
        SpecialtyDto specialtyDto = specialtyService.getSpecialtyById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Specialty successfully retrieved", specialtyDto));
    }

    @PostMapping(value = "/saveSpecialty")
    public ResponseEntity<BaseResponse<Specialty>> saveSpecialty(@RequestBody SpecialtyRequest specialtyRequest) {
        Specialty specialty = specialtyService.saveSpecialty(specialtyRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Specialty successfully saved", specialty));
    }

    @PutMapping(value = "/updateSpecialty")
    public ResponseEntity<BaseResponse<Specialty>> updateSpecialty(@RequestBody SpecialtyRequest specialtyRequest) {
        Specialty specialty = specialtyService.updateSpecialty(specialtyRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Specialty successfully updated", specialty));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        specialtyService.deleteById(id);
        return ResponseEntity.ok("Specialty successfully deleted");
    }
}
