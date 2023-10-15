package com.example.educationapp.mapper;

import com.example.educationapp.dto.StudentDto;
import com.example.educationapp.dto.request.StudentRequest;
import com.example.educationapp.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest studentRequest);
    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toDto(List<Student> students);
    List<Student> toEntity(List<StudentDto> studentDtos);

}
