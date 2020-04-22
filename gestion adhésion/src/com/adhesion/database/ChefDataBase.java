package com.adhesion.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ChefDataBase {
	
	
	private Connection conn ;
	
	public ChefDataBase() throws ClassNotFoundException, SQLException {
		
		conn = ConnectionAdhesion.InisialiserConnection(); 
	}
	
	
	
	public boolean ouvirAdhesion() throws SQLException {
		
		String SQL ="UPDATE annee_univ "
				+ "SET stat_adhesion = 1 "
				+ "WHERE  	annee_univ = '"+AdhesionDataBase.getAnneeActuel()+"'";
		
		Statement stat = conn.createStatement();
		
		int result = stat.executeUpdate(SQL);
		
		return result>0;
	}
	
	
	public boolean fermerAdhesion() throws SQLException {
		
		String SQL ="UPDATE annee_univ \r\n" + 
				"SET stat_adhesion = 0\r\n" + 
				"WHERE 	annee_univ = '"+AdhesionDataBase.getAnneeActuel()+"'";
		
		Statement stat = conn.createStatement();
		
		int result = stat.executeUpdate(SQL);
		
		return result>0;
		
		
	}

}
