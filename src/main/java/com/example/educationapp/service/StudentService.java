package com.example.educationapp.service;

import com.example.educationapp.dto.StudentDto;
import com.example.educationapp.dto.request.StudentRequest;
import com.example.educationapp.model.Student;

import java.util.List;

public interface StudentService {

    StudentDto getStudentById(Long personalDataId);
    Student saveStudent(StudentRequest studentRequest);
    Student updateStudent(StudentRequest studentRequest);
    List<StudentDto> getAll();
    void deleteById(Long personalDataId);

}
