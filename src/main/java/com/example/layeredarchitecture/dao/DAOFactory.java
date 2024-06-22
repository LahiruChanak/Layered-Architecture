package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.*;

public class DAOFactory {

    //Singleton
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    //enum
    public enum daoTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, QUERY
    }

    public SuperDAO getDAO(daoTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();

            case ITEM:
                return new ItemDAOImpl();

            case ORDER:
                return new OrderDAOImpl();

            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();

            case QUERY:
                return new QueryDAOImpl();

            default:
                return null;
        }
    }

}
