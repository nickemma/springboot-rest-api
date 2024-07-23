package com.techieemma.learning.repository;

import com.techieemma.learning.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
