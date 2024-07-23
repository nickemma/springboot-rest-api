package com.techieemma.learning.controller;


import com.techieemma.learning.data.StudentResponse;
import com.techieemma.learning.model.Student;
import com.techieemma.learning.records.StudentDTO;
import com.techieemma.learning.records.StudentResponseDTO;
import com.techieemma.learning.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@Valid @RequestBody StudentDTO studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public StudentResponse findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO findStudentById(
            @PathVariable("id") Integer id
    ) {
        return studentService.findStudentById(id);
    }

    @GetMapping("students/search/{name}")
    public List<StudentResponseDTO> findStudentsByName(
            @PathVariable("name") String name
    ) {
        return studentService.findStudentsByName(name);
    }

    @PutMapping("students/{id}")
    public Student updateStudentById(
            @PathVariable("id") Integer id,
            @RequestBody Student updatedStudent
    ) {
        return studentService.updateStudentById(id, updatedStudent);
    }

    @DeleteMapping("students/{id}")
    public List<Student> deleteStudentById(
            @PathVariable("id") Integer id
    ) {
        return studentService.deleteStudentById(id);
    }
}
