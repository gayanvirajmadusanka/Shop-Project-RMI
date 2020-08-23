package service.custom.impl;

import bo.BoFactory;
import bo.custom.CustomerBo;
import dto.CustomerDTO;
import service.custom.CustomerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    CustomerBo bo = BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);

    public CustomerServiceImpl() throws RemoteException {

    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return bo.saveCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return bo.updateCustomer(customerDTO);
    }

    @Override
    public boolean deleteCustomer(String s) throws Exception {
        return bo.deleteCustomer(s);
    }

    @Override
    public CustomerDTO getCustomer(String s) throws Exception {
        return bo.getCustomer(s);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return bo.getAllCustomers();
    }
}
