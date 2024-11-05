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
}
