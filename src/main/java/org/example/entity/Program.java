package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "program_id")
    private String programId;

    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private String duration;
    @Column(name = "fee")
    private String fee;

    @OneToMany(mappedBy = "program")
    private List<Payment> paymentList;

    public Program(String programId, String programName, String duration, String fee) {

        this.programId = programId;
        this.name = programName;
        this.duration = duration;
        this.fee = fee;
    }

    // One program can have many payments

    // Getters and Setters


    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

}
