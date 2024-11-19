package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private long payId;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private String date;

    @Column(name = "amount")
    private String amount;

    // Many payments belong to one program
    @OneToOne
    @JoinColumn(name = "sp_id") // This column must exist in your 'payment' table
    private Student_programDetail studentProgramDetail;

    public Payment(String id, String prgramId, String paymentType, String amount) {
    }

    public Payment() {

    }

}
