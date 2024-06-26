package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

    void deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    String generateNewItemId () throws SQLException, ClassNotFoundException;

    ItemDTO searchAllItems(String newItemCode) throws SQLException, ClassNotFoundException;

}
