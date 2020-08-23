package bo.custom;

import bo.SuperBo;
import dto.CustomerDTO;
import entity.Customer;

import java.util.List;

public interface CustomerBo extends SuperBo {
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    public boolean deleteCustomer(String s) throws Exception;

    public CustomerDTO getCustomer(String s) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;
}
