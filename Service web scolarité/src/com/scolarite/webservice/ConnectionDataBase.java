package com.scolarite.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
	
	private static  String dbURL = "jdbc:mysql://localhost:3306/inscription";
	private static  String username = "root";
	private static  String password = "aymen1234";
	
	
public static   Connection InisialiserConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(  
					dbURL,username,password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}  
		
		return null;
		
		
		
	}

	

}
