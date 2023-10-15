package com.example.educationapp.repository;

import com.example.educationapp.model.SpecialtyEduForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyEduFormRepository extends JpaRepository<SpecialtyEduForm, Long> {

    SpecialtyEduForm getSpecialtyEduFormById(Long id);

}
