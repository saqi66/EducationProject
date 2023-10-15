package com.example.educationapp.service.impl;

import com.example.educationapp.dto.StudentDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.StudentRequest;
import com.example.educationapp.mapper.StudentMapper;
import com.example.educationapp.model.Student;
import com.example.educationapp.repository.StudentRepository;
import com.example.educationapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public StudentDto getStudentById(Long id) {
        log.info("Fetching student details for ID: {}", id);
        StudentDto result = mapper.toDto(
                studentRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Student not found for ID: {}", id);
                            return new ResourceNotFoundException("Student", "id", id);
                        }));
        log.info("Successfully fetched student details for ID: {}", id);
        return result;
    }

    @Override
    public List<StudentDto> getAll() {
        log.info("Fetching all student details.");
        List<Student> students = studentRepository.findAll();
        log.info("Successfully fetched all student details.");
        return mapper.toDto(students);
    }

    @Override
    public Student saveStudent(StudentRequest studentRequest) {
        log.info("Saving new student.");
        Student savedStudent = studentRepository.save(mapper.toEntity(studentRequest));
        log.info("Successfully saved new student with ID: {}", savedStudent.getPersonalDataId());
        return savedStudent;
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest) {
        log.info("Updating student with ID: {}", studentRequest.getPersonalDataId());
        if (!studentRepository.existsById(studentRequest.getPersonalDataId())) {
            log.error("Student not found for updating. ID: {}", studentRequest.getPersonalDataId());
            throw new ResourceNotFoundException("Student", "Id not found", studentRequest.getPersonalDataId());
        }
        Student updatedStudent = studentRepository.save(mapper.toEntity(studentRequest));
        log.info("Successfully updated student with ID: {}", updatedStudent.getPersonalDataId());
        return updatedStudent;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting student with ID: {}", id);
        if (!studentRepository.existsById(id)) {
            log.error("Student not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Student", "Id not found", id);
        }
        studentRepository.deleteById(id);
        log.info("Successfully deleted student with ID: {}", id);
    }
}
