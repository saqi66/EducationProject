package com.example.educationapp.mapper;

import com.example.educationapp.dto.BranchDto;
import com.example.educationapp.dto.request.BranchRequest;
import com.example.educationapp.model.Branch;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    Branch toEntity(BranchRequest branchRequest);
    BranchDto toDto(Branch branch);
    Branch toEntity(BranchDto branchDto);
    List<BranchDto> toDto(List<Branch> branches);
    List<Branch> toEntity(List<BranchDto> branchDtos);
}


