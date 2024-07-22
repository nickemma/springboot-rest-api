package com.techieemma.learning;
import java.util.List;

public class StudentResponse {
    private List<Student> data;

    public StudentResponse(List<Student> data) {
        this.data = data;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
}
