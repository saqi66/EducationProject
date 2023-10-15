package com.example.educationapp.service.impl;

import com.example.educationapp.dto.SpecialtyDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.SpecialtyRequest;
import com.example.educationapp.mapper.SpecialtyMapper;
import com.example.educationapp.model.Specialty;
import com.example.educationapp.repository.SpecialtyRepository;
import com.example.educationapp.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyMapper mapper;

    @Override
    public SpecialtyDto getSpecialtyById(Long id) {
        log.info("Fetching specialty details for ID: {}", id);
        SpecialtyDto result = mapper.toDto(
                specialtyRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Specialty not found for ID: {}", id);
                            return new ResourceNotFoundException("Specialty", "id", id);
                        }));
        log.info("Successfully fetched specialty details for ID: {}", id);
        return result;
    }

    @Override
    public List<SpecialtyDto> getAll() {
        log.info("Fetching all specialty details.");
        List<Specialty> specialties = specialtyRepository.findAll();
        log.info("Successfully fetched all specialty details.");
        return mapper.toDto(specialties);
    }

    @Override
    public Specialty saveSpecialty(SpecialtyRequest specialtyRequest) {
        log.info("Saving new specialty.");
        Specialty savedSpecialty = specialtyRepository.save(mapper.toEntity(specialtyRequest));
        log.info("Successfully saved new specialty with ID: {}", savedSpecialty.getId());
        return savedSpecialty;
    }

    @Override
    public Specialty updateSpecialty(SpecialtyRequest specialtyRequest) {
        log.info("Updating specialty with ID: {}", specialtyRequest.getId());
        if (!specialtyRepository.existsById(specialtyRequest.getId())) {
            log.error("Specialty not found for updating. ID: {}", specialtyRequest.getId());
            throw new ResourceNotFoundException("Specialty", "Id not found", specialtyRequest.getId());
        }
        Specialty updatedSpecialty = specialtyRepository.save(mapper.toEntity(specialtyRequest));
        log.info("Successfully updated specialty with ID: {}", updatedSpecialty.getId());
        return updatedSpecialty;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting specialty with ID: {}", id);
        if (!specialtyRepository.existsById(id)) {
            log.error("Specialty not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Specialty", "Id not found", id);
        }
        specialtyRepository.deleteById(id);
        log.info("Successfully deleted specialty with ID: {}", id);
    }
}
