package com.example.educationapp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDataDto {


    private String firstName;
    private String middleName;
    private String lastName;
    private String egn;
    private Long isForeign;
    private String email;


}
