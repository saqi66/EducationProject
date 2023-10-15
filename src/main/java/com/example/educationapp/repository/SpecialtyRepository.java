package com.example.educationapp.repository;

import com.example.educationapp.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Specialty getSpecialtyById(Long id);

}
