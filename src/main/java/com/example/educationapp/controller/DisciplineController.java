package com.example.educationapp.controller;

import com.example.educationapp.dto.DisciplineDto;
import com.example.educationapp.dto.request.DisciplineRequest;
import com.example.educationapp.model.Discipline;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/discipline")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @GetMapping(value = "/disciplineList")
    public ResponseEntity<BaseResponse<List<DisciplineDto>>> getDisciplineInfo() {
        List<DisciplineDto> disciplineDtos = disciplineService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Discipline list successfully retrieved", disciplineDtos));
    }

    @GetMapping(value = "/getDisciplineById/{id}")
    public ResponseEntity<BaseResponse<DisciplineDto>> getDisciplineById(@PathVariable(value = "id") Long id) {
        DisciplineDto disciplineDto = disciplineService.getDisciplineById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Discipline successfully retrieved", disciplineDto));
    }

    @PostMapping(value = "/saveDiscipline")
    public ResponseEntity<BaseResponse<Discipline>> saveDiscipline(@RequestBody DisciplineRequest disciplineRequest) {
        Discipline discipline = disciplineService.saveDiscipline(disciplineRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Discipline successfully saved", discipline));
    }

    @PutMapping(value = "/updateDiscipline")
    public ResponseEntity<BaseResponse<Discipline>> updateDiscipline(@RequestBody DisciplineRequest disciplineRequest) {
        Discipline discipline = disciplineService.updateDiscipline(disciplineRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Discipline successfully updated", discipline));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        disciplineService.deleteById(id);
        return ResponseEntity.ok("Discipline successfully deleted");
    }
}
