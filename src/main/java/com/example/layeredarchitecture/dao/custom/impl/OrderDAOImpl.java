package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.entity.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace(
                "OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return rst.next();

    }

    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                entity.getOrderId(),
                entity.getOrderDate(),
                entity.getCustomerId()
        );
    }

    @Override
    public ArrayList<Order> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {}

    @Override
    public Order searchAll(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

}
