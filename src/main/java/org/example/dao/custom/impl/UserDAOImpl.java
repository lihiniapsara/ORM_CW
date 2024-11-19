package org.example.dao.custom.impl;

import jakarta.persistence.NoResultException;
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

    public User getatabyrole(String role) {
        Session session = FactoryConfiguration.getInstance().getSession();
        User user=null;

        try {
            String hql = "FROM User WHERE job_role = :role";
           user=session.createQuery(hql,User.class).setParameter("role",role).getSingleResult();
        } catch (NoResultException e) {
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            if (session != null) {
                session.close();
            }
        }
        return user;

    }

    public User getdata(String name) {
        Session session = FactoryConfiguration.getInstance().getSession();
        User user = null;
        try {
            String hql = "FROM User WHERE u_name = :name";
            user = session.createQuery(hql, User.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No user found for name: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public boolean register(User user) {
        System.out.println(user);
        boolean result = false;
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }return result;
    }

    public boolean ifhaveadmin() {
        boolean result = false;
        Session session = FactoryConfiguration.getInstance().getSession();
        String hql = "FROM User WHERE job_role = 'Admin'";
        try {
           result=session.createQuery(hql).list().size()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
