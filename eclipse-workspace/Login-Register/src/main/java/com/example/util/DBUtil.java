package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
//	 private static final String URL = "jdbc:mysql://localhost:3306/user_db";
//	 private static final String USERNAME = "root";
//	 private static final String PASSWORD = "root";
   static {
       try {
           // Load the MySQL JDBC driver
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
   }

   public static Connection getConnection() throws SQLException {
	   System.out.println("connection established!!!");
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root");
   }
}

