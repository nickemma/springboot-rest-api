package com.techieemma.learning.records;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty
        String firstName,

        @NotEmpty
        String lastName,

        @NotEmpty
        String email,

        Integer schoolId
) {
}
