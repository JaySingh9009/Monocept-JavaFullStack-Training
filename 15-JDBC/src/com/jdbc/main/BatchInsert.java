package com.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchInsert {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students (name, age, branch, result) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            for (int i = 1; i <= 5; i++) {
                ps.setString(1, "Student" + i);
                ps.setInt(2, 20 + i);
                ps.setString(3, "IT");
                ps.setDouble(4, 70 + i);

                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Batch Insert Done!");

            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
