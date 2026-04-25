package com.project.app.dao;

import com.project.app.model.Course;
import com.project.app.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course order by course_id";
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                courses.add(new Course(resultSet.getInt("course_id"), resultSet.getString("course_name")));
            }
        }
        return courses;
    }

    public boolean isValidCourseId(int id) throws SQLException {
        String sql = "SELECT 1 FROM course WHERE course_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultset = preparedStatement.executeQuery()) {
                return resultset.next();
            }
        }
    }
}
