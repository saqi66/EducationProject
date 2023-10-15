package com.example.educationapp.repository;

import com.example.educationapp.model.ScienDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScienDegreeRepository extends JpaRepository<ScienDegree, Long> {

    ScienDegree getScienDegreeById(Long id);

}
