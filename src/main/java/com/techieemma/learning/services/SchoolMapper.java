package com.techieemma.learning.services;

import com.techieemma.learning.model.School;
import com.techieemma.learning.records.SchoolDTO;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDTO dto) {
        return new School(dto.schoolName());
    }

    // Gets the list of schools with the students details attached to it
//    @GetMapping("/schools")
//    public SchoolResponse findAllSchools(){
//        return new SchoolResponse(repository.findAll());
//    }

    // A mapper to the record for the school
    public SchoolDTO toSchoolDto(School school) {
        return new SchoolDTO(school.getSchoolName());
    }
}
