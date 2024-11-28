package org.example.dao;

import org.example.dao.custom.IMPL.*;

public class DaoFactory {
    public static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getdaoFactory(){
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }



    public enum DaoTypes{
        USER,STUDENT,PROGRAM, COURSE , PAYMENT
    }
    public SuperDao getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case USER:
                return new UserDaoImpl();

            case STUDENT:
                return new StudetDaoImpl();

            case PROGRAM:
                return new ProgramDaoImpl();

            case COURSE:
                return new Course_RegistrationDaoImpl();

            case PAYMENT:
                return new PaymentDaoImpl();
        }
        return null;
    }

}
