package com.example.educationapp.repository;

import com.example.educationapp.model.Student;
import com.example.educationapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher getTeacherById(Long id);

}
