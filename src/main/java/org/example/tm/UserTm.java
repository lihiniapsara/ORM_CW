package org.example.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTm {

    private long u_id;
    private String u_name;
    private String pw;
    private String job_role;
    private String tel;

    public UserTm(String u_name, String pw, String job_role, String tel) {
        this.u_name = u_name;
        this.pw = pw;
        this.job_role = job_role;
        this.tel = tel;
    }
}
