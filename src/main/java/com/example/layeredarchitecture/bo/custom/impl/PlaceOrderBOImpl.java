package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    OrderDAO orderDAO = new OrderDAOImpl(); //Property Injection
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();   //Property Injection

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewId();
    }

    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(orderId);
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.save(dto);
    }

    @Override
    public boolean saveOrderDetail(OrderDetailDTO orderDetails) throws SQLException, ClassNotFoundException {
        return orderDetailDAO.save(orderDetails);
    }

}
