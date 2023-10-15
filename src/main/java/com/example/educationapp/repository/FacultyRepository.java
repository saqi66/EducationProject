package com.example.educationapp.repository;

import com.example.educationapp.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty getFacultyById(Long id);

}
