package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	
	private static Connection con;
	
	public static void openConnection() throws SQLException {
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root", "Aj#2942@Mysql");
		System.out.println("Connection established");
	}

	public static Connection getCon() {
		return con;
	}
	

}
