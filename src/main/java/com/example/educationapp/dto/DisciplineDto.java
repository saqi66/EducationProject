package com.example.educationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineDto {

    private String name;
    private Long lectureHours;
    private Long practiceHours;
    private Long isOptional;


}
