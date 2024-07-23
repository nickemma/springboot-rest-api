package com.techieemma.learning.records;

public record StudentDTO(
        String firstName,
        String lastName,
        String email,

        Integer schoolId
) {
}
