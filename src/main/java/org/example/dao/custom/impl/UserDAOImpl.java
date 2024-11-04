package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl {
    public List<User> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<User> query = session.createQuery("FROM User");
        List<User> user = query.list();
        session.close();
        return user;
    }
}
