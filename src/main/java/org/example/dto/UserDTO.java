package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private long u_id;
    private String u_name;
    private String pw;
    private String job_role;
    private String tel;

    public UserDTO(String u_name, String pw, String jobRole, String tel) {
    }
}
