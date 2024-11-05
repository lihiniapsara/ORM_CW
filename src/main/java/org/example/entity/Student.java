package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private   long s_id;
    @Column(name = "s_name")
    private   String s_name;
    @Column(name = "address")
    private   String address;
    @Column(name = "email")
    private   String email;
    @Column(name = "contact")
    private   String contact;

    public Student() {

    }

    public Student(long s_id, String s_name, String address, String email, String contact) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.address = address;
        this.email = email;
        this.contact = contact;
    }

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

