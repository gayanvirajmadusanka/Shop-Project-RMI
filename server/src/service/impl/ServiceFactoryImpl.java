package service.impl;

import service.ServiceFactory;
import service.custom.impl.CustomerServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    private static ServiceFactoryImpl serviceFactory;

    public ServiceFactoryImpl() throws RemoteException {
    }

    public static ServiceFactoryImpl getInstance() throws RemoteException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public <T> T getService(ServiceType serviceType) throws Exception {
        switch (serviceType) {
            case CUSTOMER:
                return (T) new CustomerServiceImpl();
            case ITEM:
                return null;
            case ORDER:
                return null;
            default:
                return null;
        }
    }
}
