package com.example.educationapp.controller;

import com.example.educationapp.dto.TeacherDto;
import com.example.educationapp.dto.request.TeacherRequest;
import com.example.educationapp.model.Teacher;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping(value = "/teacherList")
    public ResponseEntity<BaseResponse<List<TeacherDto>>> getTeacherInfo() {
        List<TeacherDto> teacherDtos = teacherService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Teacher list successfully retrieved", teacherDtos));
    }

    @GetMapping(value = "/getTeacherById/{id}")
    public ResponseEntity<BaseResponse<TeacherDto>> getTeacherById(@PathVariable(value = "id") Long id) {
        TeacherDto teacherDto = teacherService.getTeacherById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Teacher successfully retrieved", teacherDto));
    }

    @PostMapping(value = "/saveTeacher")
    public ResponseEntity<BaseResponse<Teacher>> saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        Teacher teacher = teacherService.saveTeacher(teacherRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Teacher successfully saved", teacher));
    }

    @PutMapping(value = "/updateTeacher")
    public ResponseEntity<BaseResponse<Teacher>> updateTeacher(@RequestBody TeacherRequest teacherRequest) {
        Teacher teacher = teacherService.updateTeacher(teacherRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Teacher successfully updated", teacher));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        teacherService.deleteById(id);
        return ResponseEntity.ok("Teacher successfully deleted");
    }
}
