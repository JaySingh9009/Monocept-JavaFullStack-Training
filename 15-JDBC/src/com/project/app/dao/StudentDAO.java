package com.project.app.dao;

import com.project.app.model.Student;
import com.project.app.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student s) throws SQLException {
        if (s.getAge() <= 0) throw new IllegalArgumentException("Age must be > 0");
        if (s.getName() == null || s.getName().trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        String sql = "INSERT INTO student (id, name, age, branch_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, s.getId());
            preparedStatement.setString(2, s.getName());
            preparedStatement.setInt(3, s.getAge());
            preparedStatement.setInt(4, s.getBranchId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new SQLException("Student with ID " + s.getId() + " already exists.");
            }
            throw e;
        }
    }

    public List<String> getAllStudentsWithRegistrations() throws SQLException {
        List<String> results = new ArrayList<>();
        String sql = "SELECT s.id, s.name, b.branch_name, c.course_name " +
                     "FROM student s " +
                     "LEFT JOIN branch b ON s.branch_id = b.branch_id " +
                     "LEFT JOIN registration r ON s.id = r.student_id " +
                     "LEFT JOIN course c ON r.course_id = c.course_id";
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String branch = resultSet.getString("branch_name");
                String course = resultSet.getString("course_name");
                results.add("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + 
                            ", Branch: " + (branch != null ? branch : "N/A") +
                            ", Course: " + (course != null ? course : "N/A"));
            }
        }
        return results;
    }

    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT s.*, b.branch_name FROM student s LEFT JOIN branch b ON s.branch_id = b.branch_id WHERE s.id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("branch_id"));
                    s.setBranchName(rs.getString("branch_name"));
                    return s;
                }
            }
        }
        return null;
    }

    public void updateStudent(int id, String name, int branchId) throws SQLException {
        if (getStudentById(id) == null) throw new SQLException("Student not found");

        String sql = "UPDATE student SET name = ?, branch_id = ? WHERE id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
            preparedstatement.setString(1, name);
            preparedstatement.setInt(2, branchId);
            preparedstatement.setInt(3, id);
            preparedstatement.executeUpdate();
        }
    }

    public void deleteStudentById(Connection con, int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
