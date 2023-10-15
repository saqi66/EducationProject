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
@Table(name = "faculty")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "branch_id")
    private Long branchId;
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "name", length = 45)
    @NotEmpty
    private String name;
    @Size(max = 45, message = "Maximum 45 characters")
    @Column(name = "moncode", length = 45)
    @NotEmpty
    private String monCode;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Branch> branches = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

}
