package com.jdbc.main;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class IncreaseMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter branch: ");
        String branch = sc.nextLine();

        System.out.print("Increase marks by: ");
        double inc = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET result = result + ? WHERE branch = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, inc);
            ps.setString(2, branch);

            ps.executeUpdate();
            System.out.println("Marks Updated!");

            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}