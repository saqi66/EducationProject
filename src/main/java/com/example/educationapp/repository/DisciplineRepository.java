package com.example.educationapp.repository;

import com.example.educationapp.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    Discipline getDisciplineById(Long id);

}
