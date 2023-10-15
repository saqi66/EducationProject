package com.example.educationapp.service.impl;

import com.example.educationapp.dto.ScienDegreeDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.ScienDegreeRequest;
import com.example.educationapp.mapper.ScienDegreeMapper;
import com.example.educationapp.model.ScienDegree;
import com.example.educationapp.repository.ScienDegreeRepository;
import com.example.educationapp.service.ScienDegreeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScienDegreeServiceImpl implements ScienDegreeService {
    private final ScienDegreeRepository scienDegreeRepository;
    private final ScienDegreeMapper mapper;

    @Override
    public ScienDegreeDto getScienDegreeById(Long id) {
        log.info("Fetching scien degree details for ID: {}", id);
        ScienDegreeDto result = mapper.toDto(
                scienDegreeRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("ScienDegree not found for ID: {}", id);
                            return new ResourceNotFoundException("ScienDegree", "id", id);
                        }));
        log.info("Successfully fetched scien degree details for ID: {}", id);
        return result;
    }

    @Override
    public List<ScienDegreeDto> getAll() {
        log.info("Fetching all scien degree details.");
        List<ScienDegree> scienDegrees = scienDegreeRepository.findAll();
        log.info("Successfully fetched all scien degree details.");
        return mapper.toDto(scienDegrees);
    }

    @Override
    public ScienDegree saveScienDegree(ScienDegreeRequest scienDegreeRequest) {
        log.info("Saving new scien degree.");
        ScienDegree savedScienDegree = scienDegreeRepository.save(mapper.toEntity(scienDegreeRequest));
        log.info("Successfully saved new scien degree with ID: {}", savedScienDegree.getId());
        return savedScienDegree;
    }

    @Override
    public ScienDegree updateScienDegree(ScienDegreeRequest scienDegreeRequest) {
        log.info("Updating scien degree with ID: {}", scienDegreeRequest.getId());
        if (!scienDegreeRepository.existsById(scienDegreeRequest.getId())) {
            log.error("ScienDegree not found for updating. ID: {}", scienDegreeRequest.getId());
            throw new ResourceNotFoundException("ScienDegree", "Id not found", scienDegreeRequest.getId());
        }
        ScienDegree updatedScienDegree = scienDegreeRepository.save(mapper.toEntity(scienDegreeRequest));
        log.info("Successfully updated scien degree with ID: {}", updatedScienDegree.getId());
        return updatedScienDegree;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting scien degree with ID: {}", id);
        if (!scienDegreeRepository.existsById(id)) {
            log.error("ScienDegree not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("ScienDegree", "Id not found", id);
        }
        scienDegreeRepository.deleteById(id);
        log.info("Successfully deleted scien degree with ID: {}", id);
    }
}
