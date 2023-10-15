package com.example.educationapp.controller;

import com.example.educationapp.dto.AcadPositionDto;
import com.example.educationapp.dto.request.AcadPositionRequest;
import com.example.educationapp.model.AcadPosition;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.AcadPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/acadposition")
public class AcadPositionController {

    final AcadPositionService acadPositionService;


    @GetMapping(value = "/acadPositionList")
    public ResponseEntity<BaseResponse<List<AcadPositionDto>>> getAcadPositionInfo() {
        List<AcadPositionDto> acadPositionDtos = acadPositionService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "AcadPosition list successfully finded", acadPositionDtos));
    }

    @GetMapping(value = "/getAcadPositionById/{id}")
    public ResponseEntity<BaseResponse<AcadPositionDto>> getAcadPositionById(@PathVariable(value = "id") Long id) {
        AcadPositionDto acadPositionDto = acadPositionService.getAcadPositionById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "AcadPosition successfully finded", acadPositionDto));
    }

    @PostMapping(value = "/saveAcadPosition")
    public ResponseEntity<BaseResponse<AcadPosition>> saveAcadPosition(@RequestBody AcadPositionRequest acadPositionRequest) {
        AcadPosition acadPosition = acadPositionService.saveAcadPosition(acadPositionRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "AcadPosition successfully saved", acadPosition));
    }

    @PutMapping(value = "/updateAcadPosition")
    public ResponseEntity<BaseResponse<AcadPosition>> updateAcadPosition(@RequestBody AcadPositionRequest acadPositionRequest) {
        AcadPosition acadPosition = acadPositionService.updateAcadPosition(acadPositionRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "AcadPosition successfully updated", acadPosition));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        acadPositionService.deleteById(id);
        return ResponseEntity.ok("AcadPosition successfully deleted");
    }
}