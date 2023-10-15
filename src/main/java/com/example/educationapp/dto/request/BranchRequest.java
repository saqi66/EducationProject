package com.example.educationapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BranchRequest {


    private Long id;
    private Long universityId;
    private Long cityId;
    private String name;
    private String address;
    private String postCode;


}
