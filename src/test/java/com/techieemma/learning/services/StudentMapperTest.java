package com.techieemma.learning.services;

import com.techieemma.learning.model.Student;
import com.techieemma.learning.records.StudentDTO;
import com.techieemma.learning.records.StudentResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp(){
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDTO dto = new StudentDTO(
                "John",
                "Doe",
                "johndoe@gmail.com",
               1
        );
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentResponseDtoToStudent() {
        Student student = new Student(
                "Jane",
                "doe",
                "jane@gmail.com",
                25
        );
        StudentResponseDTO responseDTO = mapper.toStudentResponseDto(student);
        assertEquals(responseDTO.firstName(), student.getFirstName());
        assertEquals(responseDTO.lastName(), student.getLastName());
        assertEquals(responseDTO.email(), student.getEmail());

    }
}