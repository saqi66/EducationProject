package com.example.educationapp.controller;

import com.example.educationapp.dto.CityDto;
import com.example.educationapp.dto.request.CityRequest;
import com.example.educationapp.model.City;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/city")
public class CityController {

    private final CityService cityService;

    @GetMapping(value = "/cityList")
    public ResponseEntity<BaseResponse<List<CityDto>>> getCityInfo() {
        List<CityDto> cityDtos = cityService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City list successfully retrieved", cityDtos));
    }

    @GetMapping(value = "/getCityById/{id}")
    public ResponseEntity<BaseResponse<CityDto>> getCityById(@PathVariable(value = "id") Long id) {
        CityDto cityDto = cityService.getCityById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City successfully retrieved", cityDto));
    }

    @PostMapping(value = "/saveCity")
    public ResponseEntity<BaseResponse<City>> saveCity(@RequestBody CityRequest cityRequest) {
        City city = cityService.saveCity(cityRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City successfully saved", city));
    }

    @PutMapping(value = "/updateCity")
    public ResponseEntity<BaseResponse<City>> updateCity(@RequestBody CityRequest cityRequest) {
        City city = cityService.updateCity(cityRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City successfully updated", city));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        cityService.deleteById(id);
        return ResponseEntity.ok("City successfully deleted");
    }
}
