package com.example.educationapp.repository;

import com.example.educationapp.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch getBranchById(Long id);

}
