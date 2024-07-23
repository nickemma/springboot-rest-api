package com.techieemma.learning.data;

import com.techieemma.learning.model.School;
import com.techieemma.learning.records.SchoolDTO;

import java.util.List;

public class SchoolResponse {

    private List<SchoolDTO> data;

    public SchoolResponse(List<SchoolDTO> data) {
        this.data = data;
    }

    public List<SchoolDTO> getData(){
        return data;
    }

    public void setData(List<SchoolDTO> data) {
        this.data = data;
    }
}
