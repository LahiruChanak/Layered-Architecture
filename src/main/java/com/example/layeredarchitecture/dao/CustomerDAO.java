package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {

    ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;

    void saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    void updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;

    void deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerId() throws SQLException, ClassNotFoundException;
}
