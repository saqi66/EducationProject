package com.example.educationapp.repository;

import com.example.educationapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getDepartmentById(Long id);

}
