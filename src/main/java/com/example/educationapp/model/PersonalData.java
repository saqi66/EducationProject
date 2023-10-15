package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edu_form")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "country_id")
    private Long countryId;
    @Size(min = 3, max = 25, message = "Minimum 3, Maximum 25 characters")
    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 3, max = 25, message = "Minimum 3, Maximum 25 characters")
    @NotBlank
    @Column(name = "middle_name")
    private String middleName;
    @Size(min = 3, max = 25, message = "Minimum 3, Maximum 25 characters")
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "egn")
    private String egn;
    @Column(name = "is_foreign")
    private Long isForeign;
    @Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    @NotEmpty
    @Column(name = "email", unique = true)
    private String email;

    @OneToOne(mappedBy = "personalData", cascade = CascadeType.ALL)
    private City city;

    @OneToOne(mappedBy = "personalData", cascade = CascadeType.ALL)
    private Country country;

    @OneToOne(mappedBy = "personalData", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

}
