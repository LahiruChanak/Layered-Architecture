package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> loadAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer");

        ArrayList<Customer> customers = new ArrayList<>();
        while (rst.next()){
            Customer entity = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            customers.add(entity);
        }
        return customers;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        return SqlUtil.execute(sql,entity.getId(),entity.getName(),entity.getAddress());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",
                entity.getName(),entity.getAddress(),entity.getId() );
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

        SqlUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }

    @Override
    public Customer searchAll(String newValue) throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        Customer customer = new Customer(newValue + "", rst.getString("name"), rst.getString("address"));
        return customer;
    }

}
