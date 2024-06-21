package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface PlaceOrderBO {

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean exist(String orderId) throws SQLException, ClassNotFoundException;

    boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

    boolean save(OrderDetailDTO orderDetails ) throws SQLException, ClassNotFoundException;

}