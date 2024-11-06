package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentDAOImpl {
    public boolean save(String id, String prgramId, String paymentType, String amount) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Payment(id, prgramId, paymentType, amount));
        transaction.commit();
        session.close();
        return true;
    }

    public List<Payment> getIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Payment> query = session.createQuery("FROM Payment");
        List<Payment> payments = query.list();
        session.close();
        return payments;
    }
}
