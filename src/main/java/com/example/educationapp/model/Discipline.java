package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discipline")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "teacher_id")
    private Long teacherId;
    @NotEmpty
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "lecture_hours")
    private Long lectureHours;
    @Column(name = "practice_hours")
    private Long practiceHours;
    @Column(name = "is_optional")
    private Long isOptional;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

}
