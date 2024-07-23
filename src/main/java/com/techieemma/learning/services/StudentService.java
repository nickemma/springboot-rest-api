package com.techieemma.learning.services;

import com.techieemma.learning.data.StudentResponse;
import com.techieemma.learning.model.Student;
import com.techieemma.learning.records.StudentDTO;
import com.techieemma.learning.records.StudentResponseDTO;
import com.techieemma.learning.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public StudentResponse findAllStudent() {
        return new StudentResponse(repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .toList());
    }

    public StudentResponseDTO findStudentById(
           Integer id
    ) {
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDTO> findStudentsByName(
            String name
    ) {
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }

    public Student updateStudentById(
           Integer id,
           Student updatedStudent
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

    public List<Student> deleteStudentById(
            Integer id
    ) {
        return Collections.singletonList(repository.findById(id).map(student -> {
            repository.deleteById(id);
            return student;
        }).orElse(null));
    }
}
