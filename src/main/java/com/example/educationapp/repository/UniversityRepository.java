package com.example.educationapp.repository;

import com.example.educationapp.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    University getUniversityById(Long id);

}
