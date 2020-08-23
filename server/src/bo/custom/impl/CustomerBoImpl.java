package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import db.HibernateUtil;
import dto.CustomerDTO;
import entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDao.setSession(session);
            session.beginTransaction();
            boolean isSaved = customerDao.save(
                    new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getSalary())
            );
            session.getTransaction().commit();
            return isSaved;

        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDao.setSession(session);
            session.beginTransaction();
            boolean isUpdated = customerDao.update(
                    new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getSalary())
            );
            session.getTransaction().commit();
            return isUpdated;

        }
    }

    @Override
    public boolean deleteCustomer(String s) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDao.setSession(session);
            session.beginTransaction();
            boolean isDeleted = customerDao.delete(s);
            session.getTransaction().commit();
            return isDeleted;
        }
    }

    @Override
    public CustomerDTO getCustomer(String s) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDao.setSession(session);
            session.beginTransaction();
            Customer c = customerDao.get(s);
            session.getTransaction().commit();
            if (c != null) {
                return new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
            } else {
                return null;
            }
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customerDao.setSession(session);
            session.beginTransaction();
            List<Customer> customerList = customerDao.getAll();
            session.getTransaction().commit();
            List<CustomerDTO> dtos = new ArrayList<>();

            for (Customer c : customerList) {
                dtos.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
            }
            return dtos;

        }
    }
}
