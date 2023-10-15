package com.example.educationapp.service;

import com.example.educationapp.dto.TeacherDto;
import com.example.educationapp.dto.request.TeacherRequest;
import com.example.educationapp.model.Teacher;

import java.util.List;

public interface TeacherService {

    TeacherDto getTeacherById(Long id);
    Teacher saveTeacher(TeacherRequest teacherRequest);
    Teacher updateTeacher(TeacherRequest teacherRequest);
    List<TeacherDto> getAll();
    void deleteById(Long id);

}
