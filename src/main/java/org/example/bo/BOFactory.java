package org.example.bo;

import org.example.bo.custom.ItemBO;
import org.example.bo.custom.impl.CustomerBOImpl;
import org.example.bo.custom.impl.ItemBOImpl;
import org.example.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,PO
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PO:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
