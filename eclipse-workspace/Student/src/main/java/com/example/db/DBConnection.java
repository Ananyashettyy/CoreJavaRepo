package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


	public static Connection getConnection() throws Exception {    	 
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

	}
}