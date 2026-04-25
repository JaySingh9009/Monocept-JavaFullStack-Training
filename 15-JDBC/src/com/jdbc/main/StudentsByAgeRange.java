package com.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentsByAgeRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter min age: ");
        int min = sc.nextInt();
        System.out.print("Enter max age: ");
        int max = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students WHERE age BETWEEN ? AND ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name") + " | " + rs.getInt("age"));
            }

            rs.close();
            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
