package com.techieemma.learning;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
        public Student create(@RequestBody Student student) {
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        return repository.save(student);
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
        return repository.findAllByFirstNameContaining(name.toLowerCase());
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
