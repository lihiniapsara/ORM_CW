package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student_programDetail {

    @Id
    private String sp_id;
    private String register_date;

    @ManyToOne
    @JoinColumn(name = "s_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
}
