package com.adhesion.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.adhesion.beans.Adhesion;

public class ReAdhisionDataBase {
	
	private Connection conn ; 
	
	
	public ReAdhisionDataBase() throws ClassNotFoundException, SQLException {
		
		conn = ConnectionAdhesion.InisialiserConnection();
	}
	
	
	
	public int FaireReAdhesion(Adhesion adhesion) throws SQLException {
		
		int idEtudiant = adhesion.getEtudiant().getId();
		
		int idAgent = adhesion.getIdAgent();
		
		boolean ResultSearchEtudiant = ChercherEtudiantAdhesion(idEtudiant);
		
		if(!ResultSearchEtudiant) {
			
			return -1;
		}
		
		else {
			String SQL = "INSERT INTO adhesion" + 
					"(id ,idEtudiant , idAgent ,  anne_univ )" + 
					"VALUES" + 
					"(null , "+idEtudiant+" , "+idAgent+" , '"+AdhesionDataBase.getAnneeActuel()+"'); ";
			
			
			
			Statement statement = conn.createStatement();
			
			int result = statement.executeUpdate(SQL);
			
			return result;
		}
		
		
	}
	
	public boolean ChercherEtudiantAdhesion(int id) throws SQLException {
		
		
		String SQL = "SELECT idEtudiant FROM adhesion WHERE idEtudiant = "+id+"";
		
		Statement statement = conn.createStatement();
		
		ResultSet result = statement.executeQuery(SQL);
		
		if(result.next()) {
			return true;
		}
		
		return false;
	}

}
