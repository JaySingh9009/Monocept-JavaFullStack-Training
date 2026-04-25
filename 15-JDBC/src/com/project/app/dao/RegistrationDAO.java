package com.project.app.dao;

import com.project.app.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationDAO {

    public void registerCourse(Connection con, int studentId, int courseId, double fees) throws SQLException {
        String sql = "INSERT INTO registration (student_id, course_id, fees_paid) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.setDouble(3, fees);
            preparedStatement.executeUpdate();
        }
    }

    public boolean isDuplicateRegistration(Connection connection, int studentId, int courseId) throws SQLException {
        String sql = "SELECT 1 FROM registration WHERE student_id = ? AND course_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void updateCourseFee(int studentId, int courseId, double fee) throws SQLException {
        if (fee <= 0) throw new IllegalArgumentException("Fee must be > 0");
        String sql = "UPDATE registration SET fees_paid = ? WHERE student_id = ? AND course_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, fee);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, courseId);
            int rows = preparedStatement.executeUpdate();
            if (rows == 0) throw new SQLException("Registration not found");
        }
    }

    public void cancelRegistration(int studentId, int courseId) throws SQLException {
        String sql = "DELETE FROM registration WHERE student_id = ? AND course_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteByStudentId(Connection con, int studentId) throws SQLException {
        String sql = "DELETE FROM registration WHERE student_id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        }
    }

    public List<String> getHighPayingStudents(double minFee) throws SQLException {
        List<String> results = new ArrayList<>();
        String sql = "SELECT s.name, c.course_name, r.fees_paid " +
                     "FROM student s " +
                     "JOIN registration r ON s.id = r.student_id " +
                     "JOIN course c ON r.course_id = c.course_id " +
                     "WHERE r.fees_paid > ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, minFee);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    results.add(rs.getString("name") + " | " + rs.getString("course_name") + " | " + rs.getDouble("fees_paid"));
                }
            }
        }
        return results;
    }

    public Map<String, Integer> getCourseWiseCount() throws SQLException {
        Map<String, Integer> counts = new HashMap<>();
        String sql = "SELECT c.course_name, COUNT(r.reg_id) as count " +
                     "FROM course c " +
                     "LEFT JOIN registration r ON c.course_id = r.course_id " +
                     "GROUP BY c.course_name";
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                counts.put(rs.getString("course_name"), rs.getInt("count"));
            }
        }
        return counts;
    }
}
