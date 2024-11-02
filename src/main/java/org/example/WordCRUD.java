package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class WordCRUD {

    Connection conn = null;

    WordCRUD(){
        conn = DBUtil.getConn();
    }

    public void addData(Word one){
        String sql = "insert into t_user (word, meaning) values ('"+ one.getWord() + "','" + one.getMeaning() + "')";

        Statement stat1 = null;
        try {
            stat1 = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stat1.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("데이터가추가됨!");
    }
}