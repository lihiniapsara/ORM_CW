package org.example.bo.custom.impl;


import org.example.dao.custom.impl.UserDAOImpl;
import org.example.dto.UserDTO;
import org.example.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserBOImpl {
    UserDAOImpl userDAO = new UserDAOImpl();
    public ArrayList<UserDTO> getAll() {
        ArrayList<UserDTO> allUsers= new ArrayList<>();
        List<User> all = userDAO.getAll();
        for(User u:all){
            allUsers.add(new UserDTO(u.getU_id(),u.getU_name(),u.getPw(),u.getJob_role(),u.getTel()));
        }
        return allUsers;
    }

    public boolean save(UserDTO userDTO) {
        System.out.println("hello");
        return userDAO.save(new User(userDTO.getU_id(),userDTO.getU_name(),userDTO.getPw(),userDTO.getJob_role(),userDTO.getTel()));
    }



    public boolean delete(String tel) {
        return userDAO.delete(tel);
    }

    public boolean update(UserDTO userDTO) {
        return userDAO.update(new User(userDTO.getU_name(),userDTO.getPw(),userDTO.getJob_role(),userDTO.getTel()));

    }

   /* public String getCurrentId() {
        return userDAO.currentId();
    }*/
 /*   UserDAOImpl userDAO = new UserDAOImpl();

    public String getCurrentId() throws SQLException, ClassNotFoundException {
        return userDAO.currentId();
    }

    public ArrayList<UserDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<UserDTO> allUsers= new ArrayList<>();
        List<User> all = userDAO.getAll();
        for(User u:all){
            allUsers.add(new UserDTO(u.getUserId(),u.getUserName(),u.getPassword(),u.getContact()));
        }
        return allUsers;
    }

    public UserDTO searchById(String tel) throws SQLException, ClassNotFoundException {
        User user=userDAO.search(tel);
        return new UserDTO(user.getUserId(),user.getUserName(),user.getPassword(),user.getContact());
    }

    public boolean save(UserDTO user) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(user.getUserId(),user.getUserName(),user.getPassword(),user.getContact()));
    }

    public boolean update(UserDTO user) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(user.getUserId(),user.getUserName(),user.getPassword(),user.getContact()));
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return userDAO.delete(id);
    }

    @Override
    public boolean checkCredentials(String id, String pw) throws SQLException, ClassNotFoundException {
        String userPw = userDAO.checkCredentials(id);
        if (userPw != null) {
            return pw.equals(userPw);
        }
        return false;
    }*/
}
