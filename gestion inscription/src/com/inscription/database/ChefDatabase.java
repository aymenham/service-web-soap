package com.inscription.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ChefDatabase {
	
	
	private Connection conn;
	
	
	public ChefDatabase() throws ClassNotFoundException, SQLException {
		
		conn = ConnectionDataBase.InisialiserConnection();
		
	}
	
	
	public boolean OuvrirAnnee() throws SQLException {
		String SQL = "UPDATE annee_univ\r\n" + 
				"SET statut_annee = 1 " + 
				"WHERE annee_univ = "+inscriptionDataBase.getCurrentAnnee()+" ";
		
		
		
		Statement statement = conn.createStatement();
		
		int result = statement.executeUpdate(SQL);
		
		
		return result>0;
	}

	
	public boolean FermerAnnee() throws SQLException {
		String SQL = "UPDATE annee_univ\r\n" + 
				"SET statut_annee = 0 " + 
				"WHERE annee_univ = "+inscriptionDataBase.getCurrentAnnee()+"";
		
		
		
		Statement statement = conn.createStatement();
		
		int result = statement.executeUpdate(SQL);
		
		
		return result>0;
	}

	public boolean OuvrirInscription() throws SQLException {
		
		
		String SQL = "UPDATE annee_univ\r\n" + 
				"SET staut_inscription = 1 " + 
				"WHERE annee_univ = "+inscriptionDataBase.getCurrentAnnee()+"";
		
		
		
		Statement statement = conn.createStatement();
		
		int result = statement.executeUpdate(SQL);
		
		
		return result>0;
		
		
	}
	
	
	public boolean FermerInscription() throws SQLException {
		
		String SQL = "UPDATE annee_univ\r\n" + 
				"SET staut_inscription = 0 " + 
				"WHERE annee_univ = "+inscriptionDataBase.getCurrentAnnee()+"";
		
		
		
		Statement statement = conn.createStatement();
		
		int result = statement.executeUpdate(SQL);
		
		
		return result>0;
		
		
	}

}
