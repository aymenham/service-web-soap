package com.inscription.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.inscription.beans.Administration;
import com.inscription.beans.Departement;
import com.inscription.beans.Etudiant;
import com.inscription.beans.Inscription;

public class inscriptionDataBase {
	
	
	private Connection conn;
	
	
	public inscriptionDataBase() throws ClassNotFoundException, SQLException {
		
		
		conn = ConnectionDataBase.InisialiserConnection();
		
		
	}
	 
	
	
	
	
	
	// login de l'agent et chef departement
	public Administration Login(String pseudo , String password) throws SQLException {
		
		
		String QUERY = "SELECT * FROM administration WHERE "
				+ "pseudo = '"+pseudo+"' AND password = '"+password+"' ";
		
		
		Statement statement = conn.createStatement();
		
		ResultSet result = statement.executeQuery(QUERY);
		
		Administration administration = null;
		
		while(result.next()) {
			
			
			int id = result.getInt(1);
			String nom = result.getString(2);
			String prenom = result.getString(3);
			String pseudoR = result.getString(4);
			String role = result.getString(6);
			
			administration = new Administration(id , nom , prenom , pseudoR , null , role);
			
			
		}
		
			conn.close();
			statement.close();
			result.close();
			
		
		
		return administration;
		
		
	}
	
	
	public boolean FaireInscription(Inscription inscription) throws SQLException {
		
		
		String SQL = "INSERT INTO etudiant "
				+ "(id , nom , prenom , date_naissance , lieu_naissance ,"
				+ " sexe ,telephone , adresse , filiere)"
				+ "VALUES"
				+ "(? , ? , ? ,? ,? ,? ,?,?,?)";
		
		
		PreparedStatement statment = conn.prepareStatement(SQL);
		
		Etudiant etudiant = inscription.getEtudiant();
		statment.setInt(1, etudiant.getId());
		statment.setString(2, etudiant.getNom());
		statment.setString(3, etudiant.getPrenom());
		statment.setString(4,  etudiant.getDataNaissance());
		statment.setString(5, etudiant.getLieuNaissance());
		statment.setString(6, etudiant.getSexe());
		statment.setString(7, etudiant.getTelephone());
		statment.setString(8, etudiant.getAsresse());
		statment.setString(9, etudiant.getFiliere());
		int insertResult = statment.executeUpdate();
		
		if(insertResult>0) {
			
			
			
		
				
				String SQL_INSCRIPTION = 
						"INSERT INTO inscriptions "
						+ "(id , idEtudiant , idAgent , anne_univ , niveau)"
						+ 	"VALUES"
						+ "(null , ? , ? ,? , ?)";
				
				PreparedStatement stat = conn.prepareStatement(SQL_INSCRIPTION);
				
				stat.setInt(1, etudiant.getId());
				stat.setInt(2, inscription.getAgent().getId());
				stat.setInt(3, getCurrentAnnee());
				stat.setString(4, inscription.getNiveau());
				
				int insertResultInscription = stat.executeUpdate();
				
				conn.close();
				stat.close();
				
				return insertResultInscription>0;
						
				
			
		}
		
		else {
			conn.close();
			statment.close();
			
			return false;
		}
		
		
		
				
		
	}
	
	
	public boolean ReInscription(Inscription inscription) throws SQLException {
		
		
		String SQL_INSCRIPTION = 
				"INSERT INTO inscriptions "
				+ "(id , idEtudiant , idAgent , anne_univ , niveau)"
				+ 	"VALUES"
				+ "(null , ? , ? ,? , ?)";
		
		PreparedStatement stat = conn.prepareStatement(SQL_INSCRIPTION);
		
		stat.setInt(1, inscription.getEtudiant().getId());
		stat.setInt(2, inscription.getAgent().getId());
		stat.setInt(3, getCurrentAnnee());
		stat.setString(4, inscription.getNiveau());
		
		
		
		int insertResultReinscription = stat.executeUpdate();
		
		conn.close();
		stat.close();
		
		return insertResultReinscription>0;
		
		
	}
	
	public Etudiant chercherEtudiant(int id) throws SQLException {
		
		String SQL = "SELECT * FROM etudiant WHERE id = "+id+"";
		
		Statement statement = conn.createStatement();
		
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
					telephone, adresse, filiere);
			conn.close();
			statement.close();
			result.close();
			return etudiant;
		}
		
		return null;
	}
	
	public Departement getStatDepartement() throws SQLException {
	
		String SQL = "SELECT * FROM annee_univ WHERE  annee_univ = "+getCurrentAnnee()+"";
		
		Statement statement = conn.createStatement();
		
		ResultSet result = statement.executeQuery(SQL);
		
		if(result.next()) {
			
			String annee_univ = result.getString(1);
			String statut_annee= (result.getInt(2)==0) ? "fermer" : "ouvert";
			String statut_inscription= (result.getInt(3)==0) ? "fermer" : "ouvert";
			Departement departement = new Departement(annee_univ, statut_annee, statut_inscription);
			
			return departement;
			
			
		}
		
		return null;
		}
	

	public boolean verifierDejaInscrit(int id) throws SQLException {
		
		String SQL = "SELECT id FROM inscriptions WHERE idEtudiant = "+id+" AND anne_univ = "+getCurrentAnnee()+"";
		
		Statement statement = conn.createStatement();
		
		ResultSet result = statement.executeQuery(SQL);
		
		if(result.next())
			return true;
		else
			return false;
		
		
	}
	
	public static String GenerateAnneUniversitaire() {
		
		Calendar calendar = Calendar.getInstance();
		
		int thisYear= calendar.get(Calendar.YEAR);
		
		int pastYear = thisYear-1;
		
		return pastYear+"-"+thisYear;
	}
	
	public static int getCurrentAnnee() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.YEAR);
		
	}
	
	
	//test 
	
	

}
