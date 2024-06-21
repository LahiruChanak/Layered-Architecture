package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO {

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

    boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

    boolean exist(String orderId) throws SQLException, ClassNotFoundException;

    OrderDTO search(String newValue) throws SQLException, ClassNotFoundException;

    boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDTO> loadAll() throws SQLException, ClassNotFoundException;

}