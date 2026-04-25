package com.project.app.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.project.app.dao.BranchDAO;
import com.project.app.dao.CourseDAO;
import com.project.app.dao.RegistrationDAO;
import com.project.app.dao.StudentDAO;
import com.project.app.model.Branch;
import com.project.app.model.Course;
import com.project.app.model.Student;
import com.project.app.util.DBUtil;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();
    private RegistrationDAO registrationDAO = new RegistrationDAO();
    private BranchDAO branchDAO = new BranchDAO();
    private CourseDAO courseDAO = new CourseDAO();

    public void addStudent(Student s) throws SQLException {
        if (!branchDAO.isValidBranchId(s.getBranchId())) {
            throw new SQLException("Invalid Branch ID: " + s.getBranchId());
        }
        studentDAO.addStudent(s);
    }

    public List<Branch> getAllBranches() throws SQLException {
        return branchDAO.getAllBranches();
    }

    public List<Course> getAllCourses() throws SQLException {
        return courseDAO.getAllCourses();
    }

    public boolean isValidBranchId(int id) throws SQLException {
        return branchDAO.isValidBranchId(id);
    }

    public boolean isValidCourseId(int id) throws SQLException {
        return courseDAO.isValidCourseId(id);
    }

    public List<String> getAllStudentsWithRegistrations() throws SQLException {
        return studentDAO.getAllStudentsWithRegistrations();
    }

    public Student getStudentById(int id) throws SQLException {
        return studentDAO.getStudentById(id);
    }

    public void registerStudent(int studentId, int courseId, double fees) throws SQLException {
        if (fees <= 0) throw new IllegalArgumentException("Fees must be positive");
        if (!courseDAO.isValidCourseId(courseId)) {
            throw new SQLException("Invalid Course ID: " + courseId);
        }
        
        try (Connection con = DBUtil.getConnection()) {
            con.setAutoCommit(false);
            try {
               
                if (studentDAO.getStudentById(studentId) == null) {
                    throw new SQLException("Student not found with ID: " + studentId);
                }
              
                if (registrationDAO.isDuplicateRegistration(con, studentId, courseId)) {
                    throw new SQLException("Student is already registered for this course.");
                }
              
                registrationDAO.registerCourse(con, studentId, courseId, fees);
                
                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    public void updateStudent(int id, String name, int branchId) throws SQLException {
        if (!branchDAO.isValidBranchId(branchId)) {
            throw new SQLException("Invalid Branch ID: " + branchId);
        }
        studentDAO.updateStudent(id, name, branchId);
    }

    public void updateCourseFee(int studentId, int courseId, double fee) throws SQLException {
        registrationDAO.updateCourseFee(studentId, courseId, fee);
    }

    public void cancelRegistration(int studentId, int courseId) throws SQLException {
        registrationDAO.cancelRegistration(studentId, courseId);
    }

    public void deleteStudent(int id) throws SQLException {
        try (Connection con = DBUtil.getConnection()) {
            con.setAutoCommit(false);
            try {
                if (studentDAO.getStudentById(id) == null) {
                    throw new SQLException("Student not found");
                }
               
                registrationDAO.deleteByStudentId(con, id);
              
                studentDAO.deleteStudentById(con, id);
                
                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    public List<String> getPremiumStudents(double minFee) throws SQLException {
        return registrationDAO.getHighPayingStudents(minFee);
    }

    public Map<String, Integer> getCourseStats() throws SQLException {
        return registrationDAO.getCourseWiseCount();
    }
}
