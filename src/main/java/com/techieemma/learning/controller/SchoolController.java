package com.techieemma.learning.controller;

import com.techieemma.learning.data.SchoolResponse;
import com.techieemma.learning.model.School;
import com.techieemma.learning.records.SchoolDTO;
import com.techieemma.learning.repository.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    private final SchoolRepository repository;

    public SchoolController(SchoolRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/schools")
    public SchoolDTO create(
            @RequestBody SchoolDTO schoolDto
    ){
        var school = toSchool(schoolDto);
       repository.save(school);
       return schoolDto;
    }

    private School toSchool(SchoolDTO dto) {
        return new School(dto.schoolName());
    }

    // Gets the list of schools with the students details attached to it
//    @GetMapping("/schools")
//    public SchoolResponse findAllSchools(){
//        return new SchoolResponse(repository.findAll());
//    }

    // A mapper to the record for the school
    private SchoolDTO toSchoolDto(School school) {
        return new SchoolDTO(school.getSchoolName());
    }

    // to expose and remove the data abstractions on the school details object to display only the school name
    @GetMapping("/schools")
    public SchoolResponse findAllSchoolsDto(){
        return new SchoolResponse(repository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .toList()
        );
    }
}
