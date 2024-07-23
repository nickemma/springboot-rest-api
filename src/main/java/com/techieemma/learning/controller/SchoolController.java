package com.techieemma.learning.controller;

import com.techieemma.learning.data.SchoolResponse;
import com.techieemma.learning.records.SchoolDTO;
import com.techieemma.learning.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO create(
            @RequestBody SchoolDTO schoolDto
    ){

       return schoolService.createSchool(schoolDto);
    }

    // to expose and remove the data abstractions on the school details object to display only the school name
    @GetMapping("/schools")
    public SchoolResponse findAllSchoolsDto(){
        return schoolService.findAllSchoolsDto();
    }
}
