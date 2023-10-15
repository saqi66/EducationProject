package com.example.educationapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SpecialtyEduFormRequest {

    private Long id;
    private Long eduFormId;
    private Long specialtyId;

}
