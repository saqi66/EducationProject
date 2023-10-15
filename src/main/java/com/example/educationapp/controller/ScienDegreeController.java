package com.example.educationapp.controller;

import com.example.educationapp.dto.ScienDegreeDto;
import com.example.educationapp.dto.request.ScienDegreeRequest;
import com.example.educationapp.model.ScienDegree;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.ScienDegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sciendegree")
public class ScienDegreeController {

    private final ScienDegreeService scienDegreeService;

    @GetMapping(value = "/scienDegreeList")
    public ResponseEntity<BaseResponse<List<ScienDegreeDto>>> getScienDegreeInfo() {
        List<ScienDegreeDto> scienDegreeDtos = scienDegreeService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "ScienDegree list successfully retrieved", scienDegreeDtos));
    }

    @GetMapping(value = "/getScienDegreeById/{id}")
    public ResponseEntity<BaseResponse<ScienDegreeDto>> getScienDegreeById(@PathVariable(value = "id") Long id) {
        ScienDegreeDto scienDegreeDto = scienDegreeService.getScienDegreeById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "ScienDegree successfully retrieved", scienDegreeDto));
    }

    @PostMapping(value = "/saveScienDegree")
    public ResponseEntity<BaseResponse<ScienDegree>> saveScienDegree(@RequestBody ScienDegreeRequest scienDegreeRequest) {
        ScienDegree scienDegree = scienDegreeService.saveScienDegree(scienDegreeRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "ScienDegree successfully saved", scienDegree));
    }

    @PutMapping(value = "/updateScienDegree")
    public ResponseEntity<BaseResponse<ScienDegree>> updateScienDegree(@RequestBody ScienDegreeRequest scienDegreeRequest) {
        ScienDegree scienDegree = scienDegreeService.updateScienDegree(scienDegreeRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "ScienDegree successfully updated", scienDegree));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        scienDegreeService.deleteById(id);
        return ResponseEntity.ok("ScienDegree successfully deleted");
    }
}
