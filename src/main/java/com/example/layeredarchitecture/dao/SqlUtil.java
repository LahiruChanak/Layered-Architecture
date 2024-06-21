package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

    public static <T> T execute(String sql, Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pstm.executeUpdate(sql + args[i]);
        }

        if (sql.startsWith("SELECT")) {
            return (T) pstm.executeQuery(sql);
        } else {
            return (T) (Boolean) (pstm.executeUpdate(sql) > 0);
        }
    }

}
