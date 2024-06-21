package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class SqlUtil {

    public static <T> T execute(String sql , Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        //pstm Loop
        for (int i=0;i<args.length;i++){
            pstm.setObject(i+1,args[i]);
        }

        //Execution Type
        if (sql.startsWith("SELECT")){
            ResultSet resultSet = pstm.executeQuery();
            return (T) resultSet;
        }else{
            return (T)(Boolean)(pstm.executeUpdate()>0);
        }
    }

}
