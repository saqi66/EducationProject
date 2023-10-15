package com.example.educationapp.service.impl;

import com.example.educationapp.dto.AcadPositionDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.AcadPositionRequest;
import com.example.educationapp.mapper.AcadPositionMapper;
import com.example.educationapp.model.AcadPosition;
import com.example.educationapp.repository.AcadPositionRepository;
import com.example.educationapp.service.AcadPositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcadPositionServiceImpl implements AcadPositionService {
    private final AcadPositionRepository acadPositionRepository;
    private final AcadPositionMapper mapper;

    @Override
    public AcadPositionDto getAcadPositionById(Long id) {
        log.info("Fetching acad position details for ID: {}", id);
        AcadPositionDto result = mapper.toDto(
                acadPositionRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("AcadPosition not found for ID: {}", id);
                            return new ResourceNotFoundException("AcadPosition", "id", id);
                        }));
        log.info("Successfully fetched acad position details for ID: {}", id);
        return result;
    }

    @Override
    public List<AcadPositionDto> getAll() {
        log.info("Fetching all acad position details.");
        List<AcadPosition> acadPositions = acadPositionRepository.findAll();
        log.info("Successfully fetched all acad position details.");
        return mapper.toDto(acadPositions);
    }

    @Override
    public AcadPosition saveAcadPosition(AcadPositionRequest acadPositionRequest) {
        log.info("Saving new acad position.");
        AcadPosition savedAcadPosition = acadPositionRepository.save(mapper.toEntity(acadPositionRequest));
        log.info("Successfully saved new acad position.");
        return savedAcadPosition;
    }

    @Override
    public AcadPosition updateAcadPosition(AcadPositionRequest acadPositionRequest) {
        log.info("Updating acad position with ID: {}", acadPositionRequest.getId());
        if (!acadPositionRepository.existsById(acadPositionRequest.getId())) {
            log.error("AcadPosition not found for updating. ID: {}", acadPositionRequest.getId());
            throw new ResourceNotFoundException("AcadPosition", "Id not found", acadPositionRequest.getId());
        }
        AcadPosition updatedAcadPosition = acadPositionRepository.save(mapper.toEntity(acadPositionRequest));

        log.info("Successfully updated acad position with ID: {}", acadPositionRequest.getId());
        return updatedAcadPosition;
    }


    @Override
    public void deleteById(Long id) {
        log.info("Deleting acad position with ID: {}", id);
        if (!acadPositionRepository.existsById(id)) {
            log.error("AcadPosition not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("AcadPosition", "Id not found", id);
        }
        acadPositionRepository.deleteById(id);
        log.info("Successfully deleted acad position with ID: {}", id);
    }
}
