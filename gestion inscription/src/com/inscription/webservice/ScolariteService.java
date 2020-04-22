package com.inscription.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.inscription.beans.Departement;
import com.inscription.beans.Etudiant;
import com.inscription.beans.EtudiantProgress;
import com.inscription.database.ConnectionDataBase;
import com.inscription.database.inscriptionDataBase;

public class ScolariteService {
	
	
	
	
	
	public Etudiant chercherEtudiant(int id) {
		
		
		try {
			
			
			String SQL = "SELECT * FROM etudiant WHERE id = "+id+"";
			
			Statement statement = ConnectionDataBase.InisialiserConnection().createStatement();
			
			ResultSet result = statement.executeQuery(SQL);
			
			if(result.next()) {
				
				int idEtudiant = result.getInt(1);
				String nom = result.getString(2);
				String prenom = result.getString(3);
				String date_naissance = result.getString(4);
				String lieu_naissance = result.getString(5);
				String sexe = result.getString(6);
				String telephone = result.getString(7);
				String adresse = result.getString(8);
				String filiere = result.getString(9);
				
				
				Etudiant etudiant = new Etudiant(idEtudiant, nom, prenom, date_naissance, lieu_naissance, sexe,
						telephone, adresse,filiere);
				ConnectionDataBase.InisialiserConnection().close();
				statement.close();
				result.close();
				return etudiant;
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	
	public boolean VerifierStatAnnee() throws SQLException {
		
		String SQL = "SELECT annee_univ FROM annee_univ\r\n" + 
				"				 WHERE  \r\n" + 
				"				annee_univ = "+inscriptionDataBase.getCurrentAnnee()+" " + 
				"				AND statut_annee = 1";
		
		Statement statement = ConnectionDataBase.InisialiserConnection().createStatement();
		
		ResultSet result = statement.executeQuery(SQL);
		
		if(result.next()) {
			
			return true;			
			
		}
		
		return false;
}
}
