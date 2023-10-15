package com.example.educationapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PersonalDataRequest {

    private Long id;
    private Long cityId;
    private Long countryId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String egn;
    private Long isForeign;
    private String email;

}
