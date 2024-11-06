package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public boolean save(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }


    public boolean delete(String tel) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM User WHERE tel = :tel").setParameter("tel", tel)
                .executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(User user) {

        Session session = FactoryConfiguration.getInstance().getSession();
        session.beginTransaction();

        String hql = "UPDATE User SET u_name = :name, pw = :pw, job_role = :job_role, tel = :tel WHERE tel = :tel";
        session.createQuery(hql)
                .setParameter("name",user.getU_name())
                .setParameter("pw",user.getPw())
                .setParameter("job_role",user.getJob_role())
                .setParameter("tel",user.getTel())
                .executeUpdate();
        session.getTransaction().commit();
        return true;

    }

   /* public String currentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT MAX(u_id) FROM User");
        String id = query.getSingleResult().toString();
        transaction.commit();
        session.close();
        return id;
    }*/
}
