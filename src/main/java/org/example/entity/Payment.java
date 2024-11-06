package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private long payId;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private String amount;

    // Many payments belong to one program
    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false) // This column must exist in your 'payment' table
    private Program program;

    public Payment(String id, String prgramId, String paymentType, String amount) {
    }

    // Getters and Setters
    public long getPayId() {
        return payId;
    }

    public void setPayId(long payId) {
        this.payId = payId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
