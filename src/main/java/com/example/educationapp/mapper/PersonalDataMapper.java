package com.example.educationapp.mapper;

import com.example.educationapp.dto.PersonalDataDto;
import com.example.educationapp.dto.request.PersonalDataRequest;
import com.example.educationapp.model.PersonalData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalDataMapper {
    PersonalData toEntity(PersonalDataRequest personalDataRequest);
    PersonalDataDto toDto(PersonalData personalData);
    PersonalData toEntity(PersonalDataDto personalDataDto);
    List<PersonalDataDto> toDto(List<PersonalData> personalDataList);
    List<PersonalData> toEntity(List<PersonalDataDto> personalDataDtos);

}
