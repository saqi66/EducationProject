package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_data_id")
    private Long personalDataId;
    @Column(name = "fac_numer", length = 45)
    @NotEmpty
    @Size(max = 45, message = "Maximum 45 characters")
    private String facNumer;
    @Column(name = "course")
    private Long course;
    @Column(name = "specialty_id")
    private Long specialtyId;
    @Column(name = "specialt_edu_form_id")
    private Long specialtyEduFormId;
    @Column(name = "is_active")
    private Long isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id", insertable = false, updatable = false)
    private PersonalData personalData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id", insertable = false, updatable = false)
    private Specialty specialty;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private SpecialtyEduForm specialtyEduForm;

}
