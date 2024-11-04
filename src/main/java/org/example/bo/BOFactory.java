package org.example.bo;


import org.example.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER
    }

   /* public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }

        return null;
    }*/
}
