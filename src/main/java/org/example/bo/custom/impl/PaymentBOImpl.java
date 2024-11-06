package org.example.bo.custom.impl;

import org.example.dao.custom.impl.PaymentDAOImpl;
import org.example.tm.PaymentTm;

import java.util.List;

public class PaymentBOImpl {
    PaymentDAOImpl paymentDAO = new PaymentDAOImpl();
    public boolean savePayment(String id, String prgramId, String paymentType, String amount) {
        return paymentDAO.save(id, prgramId, paymentType, amount);
    }


  /*  public List<PaymentTm> findAllPayments() {
        return paymentDAO.findAll();
    */}


    /*public List<String> findAllProgramIds() {
        return paymentDAO.findAllProgramIds();
    }*/


//    public List<String> findAllPaymentTypes() {
//        return paymentDAO.findAllPaymentTypes();
//    }

