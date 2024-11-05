package org.example.bo.custom.impl;

import org.example.dao.custom.impl.StudentDAOImpl;
import org.example.dto.StudentDTO;
import org.example.entity.Student;

import java.util.ArrayList;

public class StudentBOImpl {
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    public boolean save(StudentDTO studentDTO) {
        return studentDAO.save(new Student(studentDTO.getS_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getEmail(),studentDTO.getContact()));

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
        return studentDAO.update(new Student(studentDTO.getS_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getEmail(),studentDTO.getContact()));
    }
}
