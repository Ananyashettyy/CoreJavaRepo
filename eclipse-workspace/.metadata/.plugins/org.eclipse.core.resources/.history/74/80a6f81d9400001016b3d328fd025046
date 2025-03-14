package com.example.servlet;

import com.example.dao.StudentDAOImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private StudentDAOImpl studentDAO;

    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                String name = request.getParameter("name");
                String rollNo = request.getParameter("rollNo");
                int marks = Integer.parseInt(request.getParameter("marks"));
                int deptId = Integer.parseInt(request.getParameter("deptId"));

                
                try {
                	studentDAO.addStudent(name, rollNo, marks, deptId);
					response.sendRedirect("viewStudents.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            } else if ("delete".equals(action)) {
                int studentId = Integer.parseInt(request.getParameter("ID"));
                
                try {
                	studentDAO.deleteStudent(studentId);
					response.sendRedirect("viewStudents.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}