package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDTO {
    private long program_id; // Unique identifier for the program
    private String program_name; // Name of the program
    private String duration; // Duration of the program
    private String fee; // Fee of the program

    public ProgramDTO(String name, String duration, String fee) {

    }
}
