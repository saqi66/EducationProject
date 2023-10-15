package com.example.educationapp.model;

import jakarta.persistence.*;
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
public class EduForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    @NotEmpty
    private String name;
    @Column(name = "is_active")
    private Long isActive;

    @OneToOne(mappedBy = "eduForm", cascade = CascadeType.ALL)
    private SpecialtyEduForm specialtyEduForm;

}
