package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "faculty_id")
    private Long facultyId;
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    @NotEmpty
    private String name;
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "moncode", length = 45)
    @NotEmpty
    private String monCode;

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Faculty faculty;

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers = new ArrayList<>();

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Discipline discipline;

}
