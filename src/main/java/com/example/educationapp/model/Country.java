package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "counry")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Size(max = 45, message = "Maximum 45 characters")
    @NotEmpty
    @Column(name = "name", length = 45)
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id", insertable = false, updatable = false)
    private PersonalData personalData;

}
