package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public ArrayList<CustomerDTO> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<CustomerDTO> customers = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
            rst.getString("id"),
            rst.getString("name"),
            rst.getString("address")
            );
            customers.add(customerDTO);
        }
        return customers;
    }

    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer WHERE id=?");
        return rst.next();
    }

    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();

        CustomerDTO customerDTO = new CustomerDTO(
                rst.getString("id"),
                rst.getString("name"),
                rst.getString("address")
        );
        return customerDTO;
    }

}