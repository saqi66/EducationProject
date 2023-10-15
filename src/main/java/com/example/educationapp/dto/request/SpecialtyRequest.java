package com.example.educationapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SpecialtyRequest {

    private Long id;
    private String name;
    private Long deparmentId;

}
