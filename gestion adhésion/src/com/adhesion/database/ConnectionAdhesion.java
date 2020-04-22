package com.adhesion.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionAdhesion {
	
	
	private static  String dbURL = "jdbc:mysql://localhost:3306/adhesion";
	private static  String username = "root";
	private static  String password = "aymen1234";
	
	
public static   Connection InisialiserConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection(  
		dbURL,username,password);
		
		return conn;
		
	}

}
