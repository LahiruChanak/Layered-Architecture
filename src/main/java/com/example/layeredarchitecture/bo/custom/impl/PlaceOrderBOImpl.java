package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.daoTypes.ORDER); //Property Injection
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.daoTypes.ORDER_DETAIL);   //Property Injection

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
        return orderDAO.save(new Order(dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId()));
    }

    @Override
    public boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailDAO.save(new OrderDetail(dto.getOid(),dto.getItemCode(),dto.getQty(),dto.getUnitPrice()));
    }

}
