package org.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WordCRUD {

    Connection conn = null;

    WordCRUD(){
        conn = DBUtil.getConn();
    }

    public void addData(Word one){

        try (Statement stat1 = conn.createStatement()) {
            String sql = "insert into t_user (word, meaning,level) values ('"+ one.getWord() + "', '" + one.getMeaning() + "', " +one.getLevel() + ")";
            stat1.execute(sql);
            System.out.println("데이터가 추가됨!");
        } catch (SQLException e) {
            throw new RuntimeException("데이터 추가 중 오류 발생: " + e.getMessage(), e);
        }
    }
}