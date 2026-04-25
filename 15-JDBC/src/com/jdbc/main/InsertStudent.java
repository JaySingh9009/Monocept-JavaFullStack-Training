package com.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students (name, age, branch, result) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "Rahul");
            ps.setInt(2, 21);
            ps.setString(3, "CSE");
            ps.setDouble(4, 85.5);

            ps.executeUpdate();
            System.out.println("Inserted!");

            ps.close(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}