package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scien_degree")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScienDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotEmpty
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acad_position_id", insertable = false, updatable = false)
    private AcadPosition acadPosition;

}
