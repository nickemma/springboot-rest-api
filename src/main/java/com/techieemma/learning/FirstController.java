package com.techieemma.learning;

import org.springframework.web.bind.annotation.*;

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
}
