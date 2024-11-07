package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProgramDTO {
    private String program_id; // Unique identifier for the program
    private String program_name; // Name of the program
    private String duration; // Duration of the program
    private String fee; // Fee of the program

}
