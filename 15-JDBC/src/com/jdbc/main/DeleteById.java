package com.jdbc.main;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Deleted!");

            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}