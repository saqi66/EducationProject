package com.example.educationapp.controller;

import com.example.educationapp.dto.EduFormDto;
import com.example.educationapp.dto.request.EduFormRequest;
import com.example.educationapp.model.EduForm;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.EduFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/eduform")
public class EduFormController {

    private final EduFormService eduFormService;

    @GetMapping(value = "/eduFormList")
    public ResponseEntity<BaseResponse<List<EduFormDto>>> getEduFormInfo() {
        List<EduFormDto> eduFormDtos = eduFormService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "EduForm list successfully retrieved", eduFormDtos));
    }

    @GetMapping(value = "/getEduFormById/{id}")
    public ResponseEntity<BaseResponse<EduFormDto>> getEduFormById(@PathVariable(value = "id") Long id) {
        EduFormDto eduFormDto = eduFormService.getEduFormById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "EduForm successfully retrieved", eduFormDto));
    }

    @PostMapping(value = "/saveEduForm")
    public ResponseEntity<BaseResponse<EduForm>> saveEduForm(@RequestBody EduFormRequest eduFormRequest) {
        EduForm eduForm = eduFormService.saveEduForm(eduFormRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "EduForm successfully saved", eduForm));
    }

    @PutMapping(value = "/updateEduForm")
    public ResponseEntity<BaseResponse<EduForm>> updateEduForm(@RequestBody EduFormRequest eduFormRequest) {
        EduForm eduForm = eduFormService.updateEduForm(eduFormRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "EduForm successfully updated", eduForm));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        eduFormService.deleteById(id);
        return ResponseEntity.ok("Eduform successfully deleted");
    }
}
