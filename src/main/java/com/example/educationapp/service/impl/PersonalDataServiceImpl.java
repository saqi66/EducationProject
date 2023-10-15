package com.example.educationapp.service.impl;

import com.example.educationapp.dto.PersonalDataDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.PersonalDataRequest;
import com.example.educationapp.mapper.PersonalDataMapper;
import com.example.educationapp.model.PersonalData;
import com.example.educationapp.repository.PersonalDataRepository;
import com.example.educationapp.service.PersonalDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalDataServiceImpl implements PersonalDataService {
    private final PersonalDataRepository personalDataRepository;
    private final PersonalDataMapper mapper;

    @Override
    public PersonalDataDto getPersonalDataById(Long id) {
        log.info("Fetching personal data details for ID: {}", id);
        PersonalDataDto result = mapper.toDto(
                personalDataRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("PersonalData not found for ID: {}", id);
                            return new ResourceNotFoundException("PersonalData", "id", id);
                        }));
        log.info("Successfully fetched personal data details for ID: {}", id);
        return result;
    }

    @Override
    public List<PersonalDataDto> getAll() {
        log.info("Fetching all personal data details.");
        List<PersonalData> personalDatas = personalDataRepository.findAll();
        log.info("Successfully fetched all personal data details.");
        return mapper.toDto(personalDatas);
    }

    @Override
    public PersonalData savePersonalData(PersonalDataRequest personalDataRequest) {
        log.info("Saving new personal data.");
        PersonalData savedPersonalData = personalDataRepository.save(mapper.toEntity(personalDataRequest));
        log.info("Successfully saved new personal data");
        return savedPersonalData;
    }

    @Override
    public PersonalData updatePersonalData(PersonalDataRequest personalDataRequest) {
        log.info("Updating personal data with ID: {}", personalDataRequest.getId());
        if (!personalDataRepository.existsById(personalDataRequest.getId())) {
            log.error("PersonalData not found for updating. ID: {}", personalDataRequest.getId());
            throw new ResourceNotFoundException("PersonalData", "Id not found", personalDataRequest.getId());
        }
        PersonalData updatedPersonalData = personalDataRepository.save(mapper.toEntity(personalDataRequest));
        log.info("Successfully updated personal data with ID: {}", updatedPersonalData.getId());
        return updatedPersonalData;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting personal data with ID: {}", id);
        if (!personalDataRepository.existsById(id)) {
            log.error("PersonalData not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("PersonalData", "Id not found", id);
        }
        personalDataRepository.deleteById(id);
        log.info("Successfully deleted personal data with ID: {}", id);
    }
}
