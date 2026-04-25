package com.project.app.dao;

import com.project.app.model.Branch;
import com.project.app.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BranchDAO {

    public List<Branch> getAllBranches() throws SQLException {
        List<Branch> branches = new ArrayList<>();
        String sql = "SELECT * FROM branch order by branch_id";
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                branches.add(new Branch(resultSet.getInt("branch_id"), resultSet.getString("branch_name")));
            }
        }
        return branches;
    }

    public boolean isValidBranchId(int id) throws SQLException {
        String sql = "SELECT 1 FROM branch WHERE branch_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        }
    }
}
