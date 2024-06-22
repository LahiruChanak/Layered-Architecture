package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.daoTypes.CUSTOMER);    //Property Injection

    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDAO.loadAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer c : customers) {
            CustomerDTO dto = new CustomerDTO(
                    c.getId(),
                    c.getName(),
                    c.getAddress()
            );
            customerDTOS.add(dto);
        }
        return customerDTOS;
    }

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {

        customerDAO.delete(id);
    }

    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewId();
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public CustomerDTO searchAllCustomers(String newValue) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.searchAll(newValue);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
    }

}
