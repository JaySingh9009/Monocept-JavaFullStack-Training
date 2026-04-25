package com.jdbc.main;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentsByMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter minimum marks: ");
        double marks = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students WHERE result > ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, marks);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name") + " | " + rs.getDouble("result"));
            }

            rs.close();
            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
