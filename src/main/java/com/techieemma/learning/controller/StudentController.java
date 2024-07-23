package com.techieemma.learning.controller;


import com.techieemma.learning.data.StudentResponse;
import com.techieemma.learning.model.School;
import com.techieemma.learning.model.Student;
import com.techieemma.learning.records.StudentDTO;
import com.techieemma.learning.records.StudentResponseDTO;
import com.techieemma.learning.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public StudentResponseDTO create(@RequestBody StudentDTO studentDto) {
        var student = toStudent(studentDto);
        var savedStudent = repository.save(student);
        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    private StudentResponseDTO toStudentResponseDto(Student student){
        return new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @GetMapping("/students")
    public StudentResponse findAllStudent() {
        return new StudentResponse(repository.findAll());
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(
            @PathVariable("id") Integer id
    ) {
        return repository.findById(id).orElse(new Student());
    }

    @GetMapping("students/search/{name}")
    public List<Student> findStudentsByName(
            @PathVariable("name") String name
    ) {
        return repository.findAllByFirstNameContaining(name);
    }

    @PutMapping("students/{id}")
    public Student updateStudentById(
            @PathVariable("id") Integer id,
            @RequestBody Student updatedStudent
    ) {
        return repository.findById(id)
                .map(student -> {
                    if (updatedStudent.getFirstName() != null) {
                        student.setFirstName(updatedStudent.getFirstName());
                    }
                    if (updatedStudent.getLastName() != null) {
                        student.setLastName(updatedStudent.getLastName());
                    }
                    if (updatedStudent.getAge() != 0) { // Assuming age 0 is not a valid age
                        student.setAge(updatedStudent.getAge());
                    }
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    updatedStudent.setId(id);
                    return repository.save(updatedStudent);
                });

    }

    @DeleteMapping("students/{id}")
    public List<Student> deleteStudentById(
            @PathVariable("id") Integer id
    ) {
        return Collections.singletonList(repository.findById(id).map(student -> {
            repository.deleteById(id);
            return student;
        }).orElse(null));
    }
}
