package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static Connection conn = null;
    public static Connection getConn() {
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:hello.db");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
