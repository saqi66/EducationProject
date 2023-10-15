package com.example.educationapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FacultyRequest {

    private Long id;
    private Long branchId;
    private String name;
    private String monCode;

}
