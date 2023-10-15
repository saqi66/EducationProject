package com.example.educationapp.controller;

import com.example.educationapp.dto.BranchDto;
import com.example.educationapp.dto.request.BranchRequest;
import com.example.educationapp.model.Branch;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/branch")
public class BranchController {

    private final BranchService branchService;

    @GetMapping(value = "/branchList")
    public ResponseEntity<BaseResponse<List<BranchDto>>> getBranchInfo() {
        List<BranchDto> branchDtos = branchService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Branch list successfully retrieved", branchDtos));
    }

    @GetMapping(value = "/getBranchById/{id}")
    public ResponseEntity<BaseResponse<BranchDto>> getBranchById(@PathVariable(value = "id") Long id) {
        BranchDto branchDto = branchService.getBranchById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Branch successfully retrieved", branchDto));
    }

    @PostMapping(value = "/saveBranch")
    public ResponseEntity<BaseResponse<Branch>> saveBranch(@RequestBody BranchRequest branchRequest) {
        Branch branch = branchService.saveBranch(branchRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Branch successfully saved", branch));
    }

    @PutMapping(value = "/updateBranch")
    public ResponseEntity<BaseResponse<Branch>> updateBranch(@RequestBody BranchRequest branchRequest) {
        Branch branch = branchService.updateBranch(branchRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Branch successfully updated", branch));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        branchService.deleteById(id);
        return ResponseEntity.ok("Branch successfully deleted");
    }
}
