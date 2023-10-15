package com.example.educationapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TeacherRequest {

    private Long id;
    private Long departmentId;
    private Long personalDataId;
    private Long acadPositionId;
    private Long scienDegreeId;

}
