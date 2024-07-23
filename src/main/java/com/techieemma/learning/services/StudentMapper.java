package com.techieemma.learning.services;

import com.techieemma.learning.model.School;
import com.techieemma.learning.model.Student;
import com.techieemma.learning.records.StudentDTO;
import com.techieemma.learning.records.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    public StudentResponseDTO toStudentResponseDto(Student student){
        return new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
