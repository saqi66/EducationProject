package com.example.educationapp.repository;

import com.example.educationapp.model.EduForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduFormRepository extends JpaRepository<EduForm, Long> {

    EduForm getEduFormById(Long id);

}
