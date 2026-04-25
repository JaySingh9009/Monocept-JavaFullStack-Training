package com.jdbc.main;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println("Updated: " + rows);

            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}