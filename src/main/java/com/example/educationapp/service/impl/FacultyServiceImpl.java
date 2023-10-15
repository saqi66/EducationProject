package com.example.educationapp.service.impl;

import com.example.educationapp.dto.FacultyDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.FacultyRequest;
import com.example.educationapp.mapper.FacultyMapper;
import com.example.educationapp.model.Faculty;
import com.example.educationapp.repository.FacultyRepository;
import com.example.educationapp.service.FacultyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyMapper mapper;

    @Override
    public FacultyDto getFacultyById(Long id) {
        log.info("Fetching faculty details for ID: {}", id);
        FacultyDto result = mapper.toDto(
                facultyRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Faculty not found for ID: {}", id);
                            return new ResourceNotFoundException("Faculty", "id", id);
                        }));
        log.info("Successfully fetched faculty details for ID: {}", id);
        return result;
    }

    @Override
    public List<FacultyDto> getAll() {
        log.info("Fetching all faculty details.");
        List<Faculty> faculties = facultyRepository.findAll();
        log.info("Successfully fetched all faculty details.");
        return mapper.toDto(faculties);
    }

    @Override
    public Faculty saveFaculty(FacultyRequest facultyRequest) {
        log.info("Saving new faculty.");
        Faculty savedFaculty = facultyRepository.save(mapper.toEntity(facultyRequest));
        log.info("Successfully saved new faculty with ID: {}", savedFaculty.getId());
        return savedFaculty;
    }

    @Override
    public Faculty updateFaculty(FacultyRequest facultyRequest) {
        log.info("Updating faculty with ID: {}", facultyRequest.getId());
        if (!facultyRepository.existsById(facultyRequest.getId())) {
            log.error("Faculty not found for updating. ID: {}", facultyRequest.getId());
            throw new ResourceNotFoundException("Faculty", "Id not found", facultyRequest.getId());
        }
        Faculty updatedFaculty = facultyRepository.save(mapper.toEntity(facultyRequest));
        log.info("Successfully updated faculty with ID: {}", updatedFaculty.getId());
        return updatedFaculty;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting faculty with ID: {}", id);
        if (!facultyRepository.existsById(id)) {
            log.error("Faculty not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Faculty", "Id not found", id);
        }
        facultyRepository.deleteById(id);
        log.info("Successfully deleted faculty with ID: {}", id);
    }
}
