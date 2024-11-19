package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.entity.Student;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl {
    public boolean save(Student student , User user) {
        System.out.println("Saving student: " + student);  // Debugging: Print student details
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Associate User: " + user);

        student.setUser(user);

        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Student> query = session.createQuery("FROM Student");
        List<Student> students = query.list();
        session.close();
        return students;
    }

    public boolean delete(String tel) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Student WHERE contact = :tel").setParameter("tel", tel)
                .executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.beginTransaction();

        String hql = "UPDATE Student SET s_name = :name,address = :address,email = :email WHERE contact = :contact";
        session.createQuery(hql)
                .setParameter("name",student.getS_name())
                .setParameter("address",student.getAddress())
                .setParameter("email",student.getEmail())
                .setParameter("contact",student.getContact())
                .executeUpdate();
        session.getTransaction().commit();
        return true;
    }
}
