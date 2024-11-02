package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordManager manager = new WordManager();
        Connection con = null;
        boolean quit = false;
        do{
            manager.printMenu();
            int menu = sc.nextInt();
            switch (menu){
                case 4:
                    manager.addData();
                    break;

                default:
                    System.out.println("Wrong number.\n");
                    break;
            }
        }while(!quit);
    }
}

/*
* public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "hello.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            String sql = "insert into t_user (word, meaning) values ('apple', '사과')";
            Statement stat1 = con.createStatement();
            stat1.execute(sql);System.out.println("데이터가추가됨!");
            Statement stat2 = con.createStatement();  // SQL 수행
            ResultSet rs = stat2.executeQuery("SELECT ID, word, meaning FROM t_user");
            while (rs.next()) {
                String id = rs.getString("ID");
                String word = rs.getString("word");
                System.out.println(id + "   " + word);
            }
            // 결과 처리
            while (rs.next()) {
                int id = rs.getInt("id");        // id 컬럼 값을 가져옴
                String name = rs.getString("word"); // name 컬럼 값을 가져옴
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // ResultSet과 Statement 닫기
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Connection 닫기
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/