package com.techieemma.learning.services;

import com.techieemma.learning.data.SchoolResponse;
import com.techieemma.learning.records.SchoolDTO;
import com.techieemma.learning.repository.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SchoolService {

    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDTO createSchool(
          SchoolDTO schoolDto
    ){
        var school = schoolMapper.toSchool(schoolDto);
        repository.save(school);
        return schoolDto;
    }

    public SchoolResponse findAllSchoolsDto(){
        return new SchoolResponse(repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .toList()
        );
    }
}
