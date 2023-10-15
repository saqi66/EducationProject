package com.example.educationapp.service.impl;

import com.example.educationapp.dto.EduFormDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.EduFormRequest;
import com.example.educationapp.mapper.EduFormMapper;
import com.example.educationapp.model.EduForm;
import com.example.educationapp.repository.EduFormRepository;
import com.example.educationapp.service.EduFormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EduFormServiceImpl implements EduFormService {
    private final EduFormRepository eduFormRepository;
    private final EduFormMapper mapper;

    @Override
    public EduFormDto getEduFormById(Long id) {
        log.info("Fetching edu form details for ID: {}", id);
        EduFormDto result = mapper.toDto(
                eduFormRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("EduForm not found for ID: {}", id);
                            return new ResourceNotFoundException("EduForm", "id", id);
                        }));
        log.info("Successfully fetched edu form details for ID: {}", id);
        return result;
    }

    @Override
    public List<EduFormDto> getAll() {
        log.info("Fetching all edu form details.");
        List<EduForm> eduForms = eduFormRepository.findAll();
        log.info("Successfully fetched all edu form details.");
        return mapper.toDto(eduForms);
    }

    @Override
    public EduForm saveEduForm(EduFormRequest eduFormRequest) {
        log.info("Saving new edu form.");
        EduForm savedEduForm = eduFormRepository.save(mapper.toEntity(eduFormRequest));
        log.info("Successfully saved new edu form with ID: {}", savedEduForm.getId());
        return savedEduForm;
    }

    @Override
    public EduForm updateEduForm(EduFormRequest eduFormRequest) {
        log.info("Updating edu form with ID: {}", eduFormRequest.getId());
        if (!eduFormRepository.existsById(eduFormRequest.getId())) {
            log.error("EduForm not found for updating. ID: {}", eduFormRequest.getId());
            throw new ResourceNotFoundException("EduForm", "Id not found", eduFormRequest.getId());
        }
        EduForm updatedEduForm = eduFormRepository.save(mapper.toEntity(eduFormRequest));
        log.info("Successfully updated edu form with ID: {}", updatedEduForm.getId());
        return updatedEduForm;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting edu form with ID: {}", id);
        if (!eduFormRepository.existsById(id)) {
            log.error("EduForm not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("EduForm", "Id not found", id);
        }
        eduFormRepository.deleteById(id);
        log.info("Successfully deleted edu form with ID: {}", id);
    }
}
