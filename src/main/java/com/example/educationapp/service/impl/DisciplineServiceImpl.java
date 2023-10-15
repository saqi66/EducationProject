package com.example.educationapp.service.impl;

import com.example.educationapp.dto.DisciplineDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.DisciplineRequest;
import com.example.educationapp.mapper.DisciplineMapper;
import com.example.educationapp.model.Discipline;
import com.example.educationapp.repository.DisciplineRepository;
import com.example.educationapp.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DisciplineServiceImpl implements DisciplineService {
    private final DisciplineRepository disciplineRepository;
    private final DisciplineMapper mapper;

    @Override
    public DisciplineDto getDisciplineById(Long id) {
        log.info("Fetching discipline details for ID: {}", id);
        DisciplineDto result = mapper.toDto(
                disciplineRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Discipline not found for ID: {}", id);
                            return new ResourceNotFoundException("Discipline", "id", id);
                        }));
        log.info("Successfully fetched discipline details for ID: {}", id);
        return result;
    }

    @Override
    public List<DisciplineDto> getAll() {
        log.info("Fetching all discipline details.");
        List<Discipline> disciplines = disciplineRepository.findAll();
        log.info("Successfully fetched all discipline details.");
        return mapper.toDto(disciplines);
    }

    @Override
    public Discipline saveDiscipline(DisciplineRequest disciplineRequest) {
        log.info("Saving new discipline.");
        Discipline savedDiscipline = disciplineRepository.save(mapper.toEntity(disciplineRequest));
        log.info("Successfully saved new discipline with ID: {}", savedDiscipline.getId());
        return savedDiscipline;
    }

    @Override
    public Discipline updateDiscipline(DisciplineRequest disciplineRequest) {
        log.info("Updating discipline with ID: {}", disciplineRequest.getId());
        if (!disciplineRepository.existsById(disciplineRequest.getId())) {
            log.error("Discipline not found for updating. ID: {}", disciplineRequest.getId());
            throw new ResourceNotFoundException("Discipline", "Id not found", disciplineRequest.getId());
        }
        Discipline updatedDiscipline = disciplineRepository.save(mapper.toEntity(disciplineRequest));
        log.info("Successfully updated discipline with ID: {}", updatedDiscipline.getId());
        return updatedDiscipline;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting discipline with ID: {}", id);
        if (!disciplineRepository.existsById(id)) {
            log.error("Discipline not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Discipline", "Id not found", id);
        }
        disciplineRepository.deleteById(id);
        log.info("Successfully deleted discipline with ID: {}", id);
    }
}
