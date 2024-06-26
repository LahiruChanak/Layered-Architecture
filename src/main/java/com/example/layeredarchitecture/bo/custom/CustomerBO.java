package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    void deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerId() throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    CustomerDTO searchAllCustomers(String newValue) throws SQLException, ClassNotFoundException;

}
