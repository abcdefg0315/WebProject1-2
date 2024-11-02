package org.example;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class WordCRUD {

    Connection conn = null;

    WordCRUD() {
        conn = DBUtil.getConn();
    }

    public void addData(Word one) {
        String sql = "insert into t_user (word, meaning,level) values ('" + one.getWord() + "', '" + one.getMeaning() + "', " + one.getLevel() + ")";

        try (Statement stat1 = conn.createStatement()) {
            stat1.execute(sql);
            System.out.println("데이터가 추가됨!");
        } catch (SQLException e) {
            throw new RuntimeException("데이터 추가 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public void updateData(String word) {
        Scanner sc = new Scanner(System.in);
        String selectSql = "SELECT * FROM t_user WHERE word = ?";
        try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
            selectStmt.setString(1, word);
            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                System.out.print("Enter a new word >> ");
                String newWord = sc.nextLine();

                System.out.print("Enter a new meaning >> ");
                String newMeaning = sc.nextLine();

                System.out.print("Enter a new level >> ");
                int newLevel = sc.nextInt();
                sc.nextLine();

                // 업데이트 쿼리 실행
                String updateSql = "UPDATE t_user SET word = ?, meaning = ?, level = ? WHERE word = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setString(1, newWord);
                    updateStmt.setString(2, newMeaning);
                    updateStmt.setInt(3, newLevel);
                    updateStmt.setString(4, word);

                    int rowsAffected = updateStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("The word has been updated successfully!");
                    } else {
                        System.out.println("Failed to update the word.");
                    }
                }
            } else {
                System.out.println("The word does not exist in the database.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the word: " + e.getMessage(), e);
        }
    }
    public void printData(){
        String sql = "SELECT * FROM t_user";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            System.out.println("=== 전체 단어 목록 ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String word = rs.getString("word");
                String meaning = rs.getString("meaning");
                int level = rs.getInt("level");
                String createdDate = rs.getString("created_date");

                System.out.printf("ID: %d | Word: %s | Meaning: %s | Level: %d | Created Date: %s\n",
                        id, word, meaning, level, createdDate);
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving words: " + e.getMessage(), e);
        }
    }
}