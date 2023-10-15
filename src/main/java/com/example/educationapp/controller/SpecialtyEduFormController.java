package com.example.educationapp.controller;

import com.example.educationapp.dto.SpecialtyEduFormDto;
import com.example.educationapp.dto.request.SpecialtyEduFormRequest;
import com.example.educationapp.model.SpecialtyEduForm;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.SpecialtyEduFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/specialtyeduform")
public class SpecialtyEduFormController {

    private final SpecialtyEduFormService specialtyEduFormService;

    @GetMapping(value = "/specialtyEduFormList")
    public ResponseEntity<BaseResponse<List<SpecialtyEduFormDto>>> getSpecialtyEduFormInfo() {
        List<SpecialtyEduFormDto> specialtyEduFormDtos = specialtyEduFormService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "SpecialtyEduForm list successfully retrieved", specialtyEduFormDtos));
    }

    @GetMapping(value = "/getSpecialtyEduFormById/{id}")
    public ResponseEntity<BaseResponse<SpecialtyEduFormDto>> getSpecialtyEduFormById(@PathVariable(value = "id") Long id) {
        SpecialtyEduFormDto specialtyEduFormDto = specialtyEduFormService.getSpecialtyEduFormById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "SpecialtyEduForm successfully retrieved", specialtyEduFormDto));
    }

    @PostMapping(value = "/saveSpecialtyEduForm")
    public ResponseEntity<BaseResponse<SpecialtyEduForm>> saveSpecialtyEduForm(@RequestBody SpecialtyEduFormRequest specialtyEduFormRequest) {
        SpecialtyEduForm specialtyEduForm = specialtyEduFormService.saveSpecialtyEduForm(specialtyEduFormRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "SpecialtyEduForm successfully saved", specialtyEduForm));
    }

    @PutMapping(value = "/updateSpecialtyEduForm")
    public ResponseEntity<BaseResponse<SpecialtyEduForm>> updateSpecialtyEduForm(@RequestBody SpecialtyEduFormRequest specialtyEduFormRequest) {
        SpecialtyEduForm specialtyEduForm = specialtyEduFormService.updateSpecialtyEduForm(specialtyEduFormRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "SpecialtyEduForm successfully updated", specialtyEduForm));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        specialtyEduFormService.deleteById(id);
        return ResponseEntity.ok("SpecialtyEduForm successfully deleted");
    }
}
