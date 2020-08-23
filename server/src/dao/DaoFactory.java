package dao;

import dao.custom.impl.CustomerDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public enum DaoType {
        CUSTOMER, ITEM, ORDER
    }

    public <T> T getDao(DaoType daoType) {
        switch (daoType) {
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ITEM:
                return null;
            case ORDER:
                return null;
            default:
                return null;
        }
    }
}
