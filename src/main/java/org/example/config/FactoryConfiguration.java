package org.example.config;


import org.example.entity.Payment;
import org.example.entity.Program;
import org.example.entity.Student;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;

    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Student.class).addAnnotatedClass(Program.class).addAnnotatedClass(Payment.class);
        sessionFactory=configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null)?factoryConfiguration=
                new FactoryConfiguration():factoryConfiguration;

    }

    public Session getSession(){
        return  sessionFactory.openSession();

    }


    }
