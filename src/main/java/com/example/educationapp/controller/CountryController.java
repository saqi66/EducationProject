package com.example.educationapp.controller;

import com.example.educationapp.dto.CountryDto;
import com.example.educationapp.dto.request.CountryRequest;
import com.example.educationapp.model.Country;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping(value = "/countryList")
    public ResponseEntity<BaseResponse<List<CountryDto>>> getCountryInfo() {
        List<CountryDto> countryDtos = countryService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country list successfully retrieved", countryDtos));
    }

    @GetMapping(value = "/getCountryById/{id}")
    public ResponseEntity<BaseResponse<CountryDto>> getCountryById(@PathVariable(value = "id") Long id) {
        CountryDto countryDto = countryService.getCountryById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country successfully retrieved", countryDto));
    }

    @PostMapping(value = "/saveCountry")
    public ResponseEntity<BaseResponse<Country>> saveCountry(@RequestBody CountryRequest countryRequest) {
        Country country = countryService.saveCountry(countryRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country successfully saved", country));
    }

    @PutMapping(value = "/updateCountry")
    public ResponseEntity<BaseResponse<Country>> updateCountry(@RequestBody CountryRequest countryRequest) {
        Country country = countryService.updateCountry(countryRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country successfully updated", country));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        countryService.deleteById(id);
        return ResponseEntity.ok("Country successfully deleted");
    }
}
