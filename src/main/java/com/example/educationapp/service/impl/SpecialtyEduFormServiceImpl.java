package com.example.educationapp.service.impl;

import com.example.educationapp.dto.SpecialtyEduFormDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.SpecialtyEduFormRequest;
import com.example.educationapp.mapper.SpecialtyEduFormMapper;
import com.example.educationapp.model.SpecialtyEduForm;
import com.example.educationapp.repository.SpecialtyEduFormRepository;
import com.example.educationapp.service.SpecialtyEduFormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpecialtyEduFormServiceImpl implements SpecialtyEduFormService {
    private final SpecialtyEduFormRepository specialtyEduFormRepository;
    private final SpecialtyEduFormMapper mapper;

    @Override
    public SpecialtyEduFormDto getSpecialtyEduFormById(Long id) {
        log.info("Fetching specialty edu form details for ID: {}", id);
        SpecialtyEduFormDto result = mapper.toDto(
                specialtyEduFormRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("SpecialtyEduForm not found for ID: {}", id);
                            return new ResourceNotFoundException("SpecialtyEduForm", "id", id);
                        }));
        log.info("Successfully fetched specialty edu form details for ID: {}", id);
        return result;
    }

    @Override
    public List<SpecialtyEduFormDto> getAll() {
        log.info("Fetching all specialty edu form details.");
        List<SpecialtyEduForm> specialtyEduForms = specialtyEduFormRepository.findAll();
        log.info("Successfully fetched all specialty edu form details.");
        return mapper.toDto(specialtyEduForms);
    }

    @Override
    public SpecialtyEduForm saveSpecialtyEduForm(SpecialtyEduFormRequest specialtyEduFormRequest) {
        log.info("Saving new specialty edu form.");
        SpecialtyEduForm savedSpecialtyEduForm = specialtyEduFormRepository.save(mapper.toEntity(specialtyEduFormRequest));
        log.info("Successfully saved new specialty edu form with ID: {}", savedSpecialtyEduForm.getId());
        return savedSpecialtyEduForm;
    }

    @Override
    public SpecialtyEduForm updateSpecialtyEduForm(SpecialtyEduFormRequest specialtyEduFormRequest) {
        log.info("Updating specialty edu form with ID: {}", specialtyEduFormRequest.getId());
        if (!specialtyEduFormRepository.existsById(specialtyEduFormRequest.getId())) {
            log.error("SpecialtyEduForm not found for updating. ID: {}", specialtyEduFormRequest.getId());
            throw new ResourceNotFoundException("SpecialtyEduForm", "Id not found", specialtyEduFormRequest.getId());
        }
        SpecialtyEduForm updatedSpecialtyEduForm = specialtyEduFormRepository.save(mapper.toEntity(specialtyEduFormRequest));
        log.info("Successfully updated specialty edu form with ID: {}", updatedSpecialtyEduForm.getId());
        return updatedSpecialtyEduForm;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting specialty edu form with ID: {}", id);
        if (!specialtyEduFormRepository.existsById(id)) {
            log.error("SpecialtyEduForm not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("SpecialtyEduForm", "Id not found", id);
        }
        specialtyEduFormRepository.deleteById(id);
        log.info("Successfully deleted specialty edu form with ID: {}", id);
    }
}
