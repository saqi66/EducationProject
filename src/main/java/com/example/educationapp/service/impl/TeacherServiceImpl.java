package com.example.educationapp.service.impl;

import com.example.educationapp.dto.TeacherDto;
import com.example.educationapp.dto.exception.ResourceNotFoundException;
import com.example.educationapp.dto.request.TeacherRequest;
import com.example.educationapp.mapper.TeacherMapper;
import com.example.educationapp.model.Teacher;
import com.example.educationapp.repository.TeacherRepository;
import com.example.educationapp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper mapper;

    @Override
    public TeacherDto getTeacherById(Long id) {
        log.info("Fetching teacher details for ID: {}", id);
        TeacherDto result = mapper.toDto(
                teacherRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Teacher not found for ID: {}", id);
                            return new ResourceNotFoundException("Teacher", "id", id);
                        }));
        log.info("Successfully fetched teacher details for ID: {}", id);
        return result;
    }

    @Override
    public List<TeacherDto> getAll() {
        log.info("Fetching all teacher details.");
        List<Teacher> teachers = teacherRepository.findAll();
        log.info("Successfully fetched all teacher details.");
        return mapper.toDto(teachers);
    }

    @Override
    public Teacher saveTeacher(TeacherRequest teacherRequest) {
        log.info("Saving new teacher.");
        Teacher savedTeacher = teacherRepository.save(mapper.toEntity(teacherRequest));
        log.info("Successfully saved new teacher with ID: {}", savedTeacher.getId());
        return savedTeacher;
    }

    @Override
    public Teacher updateTeacher(TeacherRequest teacherRequest) {
        log.info("Updating teacher with ID: {}", teacherRequest.getId());
        if (!teacherRepository.existsById(teacherRequest.getId())) {
            log.error("Teacher not found for updating. ID: {}", teacherRequest.getId());
            throw new ResourceNotFoundException("Teacher", "Id not found", teacherRequest.getId());
        }
        Teacher updatedTeacher = teacherRepository.save(mapper.toEntity(teacherRequest));
        log.info("Successfully updated teacher with ID: {}", updatedTeacher.getId());
        return updatedTeacher;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting teacher with ID: {}", id);
        if (!teacherRepository.existsById(id)) {
            log.error("Teacher not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Teacher", "Id not found", id);
        }
        teacherRepository.deleteById(id);
        log.info("Successfully deleted teacher with ID: {}", id);
    }
}
