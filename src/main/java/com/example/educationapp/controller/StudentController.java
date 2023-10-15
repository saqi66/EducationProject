package com.example.educationapp.controller;

import com.example.educationapp.dto.StudentDto;
import com.example.educationapp.dto.request.StudentRequest;
import com.example.educationapp.model.Student;
import com.example.educationapp.model.response.BaseResponse;
import com.example.educationapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/studentList")
    public ResponseEntity<BaseResponse<List<StudentDto>>> getStudentInfo() {
        List<StudentDto> studentDtos = studentService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Student list successfully retrieved", studentDtos));
    }

    @GetMapping(value = "/getStudentById/{id}")
    public ResponseEntity<BaseResponse<StudentDto>> getStudentById(@PathVariable(value = "id") Long personalDataId) {
        StudentDto studentDto = studentService.getStudentById(personalDataId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Student successfully retrieved", studentDto));
    }

    @PostMapping(value = "/saveStudent")
    public ResponseEntity<BaseResponse<Student>> saveStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.saveStudent(studentRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Student successfully saved", student));
    }

    @PutMapping(value = "/updateStudent")
    public ResponseEntity<BaseResponse<Student>> updateStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.updateStudent(studentRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Student successfully updated", student));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok("Student successfully deleted");
    }
}
