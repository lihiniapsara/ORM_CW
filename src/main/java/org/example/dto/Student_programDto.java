package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student_programDto {
    private String spid;
    private String registerDate;
    private double reg_fees;
    private StudentDto student;
    private ProgramDto program;
}
