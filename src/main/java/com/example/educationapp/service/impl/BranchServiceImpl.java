package com.example.educationapp.service.impl;

import com.example.educationapp.dto.BranchDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.BranchRequest;
import com.example.educationapp.mapper.BranchMapper;
import com.example.educationapp.model.Branch;
import com.example.educationapp.repository.BranchRepository;
import com.example.educationapp.service.BranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper mapper;

    @Override
    public BranchDto getBranchById(Long id) {
        log.info("Fetching branch details for ID: {}", id);
        BranchDto result = mapper.toDto(
                branchRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Branch not found for ID: {}", id);
                            return new ResourceNotFoundException("Branch", "id", id);
                        }));
        log.info("Successfully fetched branch details for ID: {}", id);
        return result;
    }

    @Override
    public List<BranchDto> getAll() {
        log.info("Fetching all branch details.");
        List<Branch> branches = branchRepository.findAll();
        log.info("Successfully fetched all branch details.");
        return mapper.toDto(branches);
    }

    @Override
    public Branch saveBranch(BranchRequest branchRequest) {
        log.info("Saving new branch.");
        Branch savedBranch = branchRepository.save(mapper.toEntity(branchRequest));
        log.info("Successfully saved new branch.");
        return savedBranch;
    }

    @Override
    public Branch updateBranch(BranchRequest branchRequest) {
        log.info("Updating branch with ID: {}", branchRequest.getId());
        if (!branchRepository.existsById(branchRequest.getId())) {
            log.error("Branch not found for updating. ID: {}", branchRequest.getId());
            throw new ResourceNotFoundException("Branch", "Id not found", branchRequest.getId());
        }
        Branch updatedBranch = branchRepository.save(mapper.toEntity(branchRequest));
        log.info("Successfully updated branch with ID: {}", branchRequest.getId());
        return updatedBranch;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting branch with ID: {}", id);
        if (!branchRepository.existsById(id)) {
            log.error("Branch not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Branch", "Id not found", id);
        }
        branchRepository.deleteById(id);
        log.info("Successfully deleted branch with ID: {}", id);
    }
}
