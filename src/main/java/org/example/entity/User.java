package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long u_id;
    @Column(name = "u_name")
    private String u_name;
    @Column(name = "pw")
    private String pw;
    @Column(name = "job_role")
    private String job_role;
    @Column(name = "tel")
    private String tel;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> studentList;




    public User() {
    }

    public User(long u_id, String u_name, String pw, String job_role, String tel) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.pw = pw;
        this.job_role = job_role;
        this.tel = tel;
    }

    public User(String uName, String pw, String jobRole, String tel) {
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
