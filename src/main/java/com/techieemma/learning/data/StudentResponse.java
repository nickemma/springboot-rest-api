package com.techieemma.learning.data;

import com.techieemma.learning.records.StudentResponseDTO;

import java.util.List;

public class StudentResponse {
    private List<StudentResponseDTO> data;

    public StudentResponse(List<StudentResponseDTO> data) {
        this.data = data;
    }

    public List<StudentResponseDTO> getData() {
        return data;
    }

    public void setData(List<StudentResponseDTO> data) {
        this.data = data;
    }
}
