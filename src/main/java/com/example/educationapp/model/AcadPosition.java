package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "acad_position")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcadPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotEmpty
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    private String name;

    @OneToOne(mappedBy = "acadPosition", cascade = CascadeType.ALL)
    private ScienDegree scienDegree;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

}
