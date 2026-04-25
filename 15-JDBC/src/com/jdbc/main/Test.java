package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "jay"; 
        
        try {
           
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String query = "SELECT * FROM students";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String branch = resultSet.getString("branch");
                double result = resultSet.getInt("result");

                System.out.println(id + " | " + name + " | " + age + " | " + branch + " | " + result);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}