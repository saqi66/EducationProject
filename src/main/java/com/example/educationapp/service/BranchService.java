package com.example.educationapp.service;

import com.example.educationapp.dto.BranchDto;
import com.example.educationapp.dto.request.BranchRequest;
import com.example.educationapp.model.Branch;

import java.util.List;

public interface BranchService {

    BranchDto getBranchById(Long id);
    Branch saveBranch(BranchRequest branchRequest);
    Branch updateBranch(BranchRequest branchRequest);
    List<BranchDto> getAll();
    void deleteById(Long id);

}
