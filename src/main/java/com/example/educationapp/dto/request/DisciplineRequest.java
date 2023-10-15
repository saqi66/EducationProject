package com.example.educationapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DisciplineRequest {

    private Long id;
    private Long departmentId;
    private Long teacherId;
    private String name;
    private Long lectureHours;
    private Long practiceHours;
    private Long isOptional;

}
