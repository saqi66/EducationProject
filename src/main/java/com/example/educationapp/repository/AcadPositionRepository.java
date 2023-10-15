package com.example.educationapp.repository;

import com.example.educationapp.model.AcadPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcadPositionRepository extends JpaRepository<AcadPosition, Long> {

    AcadPosition getAcadPositionById(Long id);

}
