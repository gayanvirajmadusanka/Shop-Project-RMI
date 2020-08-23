package service;

public interface ServiceFactory extends SuperService {
    public enum ServiceType {
        CUSTOMER, ITEM, ORDER
    }

    public <T> T getService(ServiceType serviceType) throws Exception;
}
