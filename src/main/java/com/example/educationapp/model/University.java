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
@Table(name = "university")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Size(max = 45, message = "Maximum 45 characters")
    @NotEmpty
    @Column(name = "name", length = 45)
    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Branch> branches = new ArrayList<>();

}
