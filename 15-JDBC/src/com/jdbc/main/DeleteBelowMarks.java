package com.jdbc.main;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteBelowMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter threshold marks: ");
        double marks = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE result < ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, marks);
            ps.executeUpdate();

            System.out.println("Deleted records!");

            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}