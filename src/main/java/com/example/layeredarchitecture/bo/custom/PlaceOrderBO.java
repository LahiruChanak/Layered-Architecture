package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

    boolean saveOrderDetail(OrderDetailDTO orderDetails ) throws SQLException, ClassNotFoundException;

}