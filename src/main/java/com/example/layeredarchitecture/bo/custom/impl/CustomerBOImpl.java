package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> loadAll() throws SQLException, ClassNotFoundException{
        return customerDAO.loadAll();
    }

    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.save(dto);
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.exist(id);
    }

    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.update(dto);
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.delete(id);
    }

    public String generateNewId() throws SQLException, ClassNotFoundException{
        return customerDAO.generateNewId();
    }

    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException{
        return customerDAO.search(newValue);
    }
}
