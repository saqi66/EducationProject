package com.example.educationapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "specialty_edu_form")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialtyEduForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "edu_form_id")
    private Long eduFormId;
    @Column(name = "specialty_id")
    private Long specialtyId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_personal_data_id", insertable = false, updatable = false)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "edu_form_id", insertable = false, updatable = false)
    private EduForm eduForm;

}
