package com.example.educationapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "branch")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "university_id")
    private Long universityId;
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "name", length = 45)
    @Size(max = 45, message = "Maximum 45 characters")
    @NotEmpty
    private String name;
    @Column(name = "address", length = 45)
    @Size(max = 45, message = "Maximum 45 characters")
    @NotEmpty
    private String address;
    @Column(name = "postcode", length = 45)
    @Size(max = 45, message = "Maximum 45 characters")
    @NotEmpty
    private String postCode;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id", insertable = false, updatable = false)
    private Faculty faculty;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id", insertable = false, updatable = false)
    private University university;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

}
