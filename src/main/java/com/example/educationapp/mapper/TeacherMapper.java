package com.example.educationapp.mapper;

import com.example.educationapp.dto.TeacherDto;
import com.example.educationapp.dto.request.TeacherRequest;
import com.example.educationapp.model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity(TeacherRequest teacherRequest);
    TeacherDto toDto(Teacher teacher);
    Teacher toEntity(TeacherDto teacherDto);
    List<TeacherDto> toDto(List<Teacher> teachers);
    List<Teacher> toEntity(List<TeacherDto> teacherDtos);

}
