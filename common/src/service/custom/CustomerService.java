package service.custom;

import dto.CustomerDTO;
import service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {

    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    public boolean deleteCustomer(String s) throws Exception;

    public CustomerDTO getCustomer(String s) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;
}
