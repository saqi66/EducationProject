package com.example.educationapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequest {

    private Long personalDataId;

    private String facNumer;
    private Long course;
    private Long specialtyId;
    private Long specialtyEduFormId;
    private Long isActive;

}
