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
        String sql = "INSERT INTO t_user (word, meaning, level, created_date, memorized) VALUES ('"
                + one.getWord() + "', '" + one.getMeaning() + "', " + one.getLevel()
                + ", '" + one.getCreated_date() + "', '" + one.isMemorized() + "')";

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

                System.out.print("Enter a memorized (t or f) >> ");
                boolean memorized;
                String ft = sc.nextLine();

                if (ft.equals("f")) {
                    memorized = false;
                } else if (ft.equals("t")) {
                    memorized = true;
                } else {
                    System.out.println("Invalid input. Please enter 't' for true or 'f' for false.");
                    return;
                }

                // 업데이트 쿼리 실행
                String updateSql = "UPDATE t_user SET word = ?, meaning = ?, level = ?,memorized = ? WHERE word = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setString(1, newWord);
                    updateStmt.setString(2, newMeaning);
                    updateStmt.setInt(3, newLevel);
                    updateStmt.setBoolean(4, memorized);
                    updateStmt.setString(5, word);

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
                boolean memorized = rs.getBoolean("memorized");

                System.out.printf("ID: %d | Word: %s | Meaning: %s | Level: %d | Memorized: %b | Created Date: %s\n",
                        id, word, meaning, level, memorized, createdDate);
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving words: " + e.getMessage(), e);
        }
    }
    public void deleteData(String word){
        String sql = "DELETE FROM t_user WHERE word = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, word);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("The word has been successfully deleted.");
            } else {
                System.out.println("No word found with the provided name.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting the word: " + e.getMessage(), e);
        }
    }
}