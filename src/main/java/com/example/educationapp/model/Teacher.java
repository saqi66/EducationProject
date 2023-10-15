package com.example.educationapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "personal_data_id")
    private Long personalDataId;
    @Column(name = "acad_position_id")
    private Long acadPositionId;
    @Column(name = "scien_degree_id")
    private Long scienDegreeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private PersonalData personalData;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Discipline> disciplines = new ArrayList<>();

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private AcadPosition acadPosition;

}
