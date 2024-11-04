package org.example.dao;

import org.example.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO {/*
    public String currentId() throws SQLException, ClassNotFoundException ;

    public T search(String tel) throws SQLException, ClassNotFoundException ;*/

    public boolean save(T entity) throws SQLException, ClassNotFoundException ;

    public boolean update(Item entity) throws SQLException, ClassNotFoundException ;

    public boolean delete(String tel) throws SQLException, ClassNotFoundException ;
    public List<Item> getAll() throws SQLException, ClassNotFoundException ;

}
