package com.example.educationapp.repository;

import com.example.educationapp.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    PersonalData getPersonalDataById(Long id);

}
