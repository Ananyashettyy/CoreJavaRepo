package com.example.dao;

import java.sql.*;
import java.util.*;

import com.example.db.DBConnection;

public class StudentDAOImpl implements IStudentDAO{

	@Override
    public void addStudent(String name, String rollNo, int marks, int deptId) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO student (name, rollNo, marks, deptId) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, rollNo);
        ps.setInt(3, marks);
        ps.setInt(4, deptId);
        ps.executeUpdate();
        con.close();
    }

    @Override
    public List<String> getAllStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT s.ID, s.name, s.rollNo, s.marks, d.dept_name " +
                       "FROM student s " +
                       "JOIN department d ON s.deptID = d.deptID";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<String> studentList = new ArrayList<>();
        while (rs.next()) {
            studentList.add("ID: " + rs.getInt("ID") +
                            ", Name: " + rs.getString("name") +
                            ", Roll No: " + rs.getString("rollNo") +
                            ", Marks: " + rs.getInt("marks") +
                            ", Department: " + rs.getString("dept_name"));
        }
        con.close();
        return studentList;
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM student WHERE ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    @Override
    public List<String> getDepartments() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM department");

        List<String> departmentList = new ArrayList<>();
        while (rs.next()) {
            departmentList.add(rs.getInt("deptId") + " - " + rs.getString("dept_name"));
        }
        con.close();
        return departmentList;
    }

}