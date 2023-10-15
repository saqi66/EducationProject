package com.example.educationapp.service.impl;

import com.example.educationapp.dto.UniversityDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.UniversityRequest;
import com.example.educationapp.mapper.UniversityMapper;
import com.example.educationapp.model.University;
import com.example.educationapp.repository.UniversityRepository;
import com.example.educationapp.service.UniversityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;
    private final UniversityMapper mapper;

    @Override
    public UniversityDto getUniversityById(Long id) {
        log.info("Fetching university details for ID: {}", id);
        UniversityDto result = mapper.toDto(
                universityRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("University not found for ID: {}", id);
                            return new ResourceNotFoundException("University", "id", id);
                        }));
        log.info("Successfully fetched university details for ID: {}", id);
        return result;
    }

    @Override
    public List<UniversityDto> getAll() {
        log.info("Fetching all university details.");
        List<University> universities = universityRepository.findAll();
        log.info("Successfully fetched all university details.");
        return mapper.toDto(universities);
    }

    @Override
    public University saveUniversity(UniversityRequest universityRequest) {
        log.info("Saving new university.");
        University savedUniversity = universityRepository.save(mapper.toEntity(universityRequest));
        log.info("Successfully saved new university with ID: {}", savedUniversity.getId());
        return savedUniversity;
    }

    @Override
    public University updateUniversity(UniversityRequest universityRequest) {
        log.info("Updating university with ID: {}", universityRequest.getId());
        if (!universityRepository.existsById(universityRequest.getId())) {
            log.error("University not found for updating. ID: {}", universityRequest.getId());
            throw new ResourceNotFoundException("University", "Id not found", universityRequest.getId());
        }
        University updatedUniversity = universityRepository.save(mapper.toEntity(universityRequest));
        log.info("Successfully updated university with ID: {}", updatedUniversity.getId());
        return updatedUniversity;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting university with ID: {}", id);
        if (!universityRepository.existsById(id)) {
            log.error("University not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("University", "Id not found", id);
        }
        universityRepository.deleteById(id);
        log.info("Successfully deleted university with ID: {}", id);
    }
}
