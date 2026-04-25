package com.jdbc.main;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateBranchMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET branch = ?, result = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, branch);
            ps.setDouble(2, marks);
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("Updated!");

            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
