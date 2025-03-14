package com.example.dao;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
	void addStudent(String name, String rollNo, int marks, int deptId) throws Exception;
	void deleteStudent(int ID) throws Exception;
	List<String> getAllStudents() throws Exception;
	List<String> getDepartments() throws Exception;
}