package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "specialty")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotEmpty
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "department_id")
    private Long deparmentId;

    @OneToOne(mappedBy = "specialty", cascade = CascadeType.ALL)
    private Student student;

}
