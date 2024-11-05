package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {

    private long s_id;

    private String name;
    private String address;
    private String email;
    private String contact;
    public StudentDTO(String name, String address, String email, String contact) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact = contact;
    }

}
