package org.example.bo.custom.impl;

import org.example.dao.custom.impl.StudentDAOImpl;
import org.example.dto.StudentDTO;
import org.example.dto.UserDTO;
import org.example.entity.Student;
import org.example.entity.User;

import java.util.ArrayList;

public class StudentBOImpl {
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    public boolean save(StudentDTO studentDTO, UserDTO userDTO) {
        System.out.println("2");
        return studentDAO.save(new Student(studentDTO.getS_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getEmail(),studentDTO.getContact()),new User(userDTO.getU_id(),userDTO.getU_name(),userDTO.getPw(),userDTO.getJob_role(),userDTO.getTel()));
    }

    public ArrayList<StudentDTO> getAll() {
        ArrayList<StudentDTO> allStudents = new ArrayList<>();
        for (Student student : studentDAO.getAll()) {
            allStudents.add(new StudentDTO(student.getS_id(),student.getS_name(),student.getAddress(),student.getEmail(),student.getContact()));
        }
        return allStudents;
    }

    public boolean delete(String tel) {
        return studentDAO.delete(tel);
    }

    public boolean update(StudentDTO studentDTO) {
        return studentDAO.update(new Student(studentDTO.getName(),studentDTO.getAddress(),studentDTO.getEmail(),studentDTO.getContact()));
    }
}
