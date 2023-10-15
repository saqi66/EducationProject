package com.example.educationapp.service;

import com.example.educationapp.dto.PersonalDataDto;
import com.example.educationapp.dto.request.PersonalDataRequest;
import com.example.educationapp.model.PersonalData;

import java.util.List;

public interface PersonalDataService {

    PersonalDataDto getPersonalDataById(Long id);
    PersonalData savePersonalData(PersonalDataRequest personalDataRequest);
    PersonalData updatePersonalData(PersonalDataRequest personalDataRequest);
    List<PersonalDataDto> getAll();
    void deleteById(Long id);

}
