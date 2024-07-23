package com.techieemma.learning.repository;

import com.techieemma.learning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstNameContaining(String name);
}
