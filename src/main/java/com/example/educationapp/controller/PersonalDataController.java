package com.example.educationapp.controller;

import com.example.educationapp.dto.PersonalDataDto;
import com.example.educationapp.dto.request.PersonalDataRequest;
import com.example.educationapp.model.PersonalData;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.PersonalDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/personaldata")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @GetMapping(value = "/personalDataList")
    public ResponseEntity<BaseResponse<List<PersonalDataDto>>> getPersonalDataInfo() {
        List<PersonalDataDto> personalDataDtos = personalDataService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "PersonalData list successfully retrieved", personalDataDtos));
    }

    @GetMapping(value = "/getPersonalDataById/{id}")
    public ResponseEntity<BaseResponse<PersonalDataDto>> getPersonalDataById(@PathVariable(value = "id") Long id) {
        PersonalDataDto personalDataDto = personalDataService.getPersonalDataById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "PersonalData successfully retrieved", personalDataDto));
    }

    @PostMapping(value = "/savePersonalData")
    public ResponseEntity<BaseResponse<PersonalData>> savePersonalData(@RequestBody PersonalDataRequest personalDataRequest) {
        PersonalData personalData = personalDataService.savePersonalData(personalDataRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "PersonalData successfully saved", personalData));
    }

    @PutMapping(value = "/updatePersonalData")
    public ResponseEntity<BaseResponse<PersonalData>> updatePersonalData(@RequestBody PersonalDataRequest personalDataRequest) {
        PersonalData personalData = personalDataService.updatePersonalData(personalDataRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "PersonalData successfully updated", personalData));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        personalDataService.deleteById(id);
        return ResponseEntity.ok("PersonalData successfully deleted");
    }
}