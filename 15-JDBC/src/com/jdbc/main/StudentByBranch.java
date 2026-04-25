package com.jdbc.main;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentByBranch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter branch: ");
        String branch = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students WHERE branch = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, branch);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name"));
            }

            rs.close();
            ps.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
