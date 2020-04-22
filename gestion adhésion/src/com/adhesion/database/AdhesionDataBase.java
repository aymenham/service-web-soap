package com.adhesion.database;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.adhesion.beans.Adhesion;
import com.adhesion.beans.Administration;
import com.scolarite.webservice.ScolariteServiceStub.Etudiant;
import com.scolarite.webservice.WebServiceClient;

public class AdhesionDataBase {
	
	
	private Connection conn ; 
	
	
	public AdhesionDataBase() throws ClassNotFoundException, SQLException {
		
		conn = ConnectionAdhesion.InisialiserConnection();
	}
	
	
public Administration Login(String pseudo , String password) throws SQLException {
		
		
		String QUERY = "SELECT * FROM adminstration WHERE "
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


public boolean getEtatAdhesion() throws SQLException {
	
	String SQL = "SELECT stat_adhesion"
			+ " FROM annee_univ "
			+ "WHERE annee_univ = '"+getAnneeActuel()+"'";
	
	Statement statement = conn.createStatement();
	
	ResultSet result = statement.executeQuery(SQL);
	
	if(result.next()) {
		
		
		int  statut_annee= result.getInt(1);
		
		if(statut_annee==0) {
			return false;
		}
		
		else if (statut_annee==1) {
			return true;
		}
		
		
		
		
	}
	
	return false;
}

public int FaireAdhesion(Adhesion adhesion) throws ClassNotFoundException, SQLException, RemoteException {
	
	int idEtudiant = adhesion.getEtudiant().getId();
	int idAgent = adhesion.getIdAgent();
	
	Etudiant etudiant = new WebServiceClient().getEtudiant(idEtudiant);
	
	if(etudiant==null) {
		return -1;
	}
	
	else {
		
		String SQLEtudiant = "INSERT INTO etudiant "
				+ "(id , nom , prenom , date_naissance , lieu_naissance ,"
				+ " sexe ,telephone , adresse , filiere)"
				+ "VALUES"
				+ "(? , ? , ? ,? ,? ,? ,?,?,?)";
		
		
		PreparedStatement statment = conn.prepareStatement(SQLEtudiant);
		
		
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
			
			String SQL = "INSERT INTO adhesion" + 
					"(id ,idEtudiant , idAgent ,  anne_univ )\r\n" + 
					"VALUES" + 
					"(null , "+idEtudiant+" , "+idAgent+" , '"+getAnneeActuel()+"'); ";
			
			
			
			Statement statement = conn.createStatement();
			
			int result = statement.executeUpdate(SQL);
			
			return result;
		}
		
	
		
		return 0;
		
	
		
	}
	
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
				"(null , "+idEtudiant+" , "+idAgent+" , '"+getAnneeActuel()+"'); ";
		
		
		
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

public boolean verifierDejaAdhesion(int id) throws SQLException {
	
	String SQL = "SELECT id FROM adhesion WHERE idEtudiant = "+id+" AND anne_univ = "+getAnneeActuel()+"";
	
	Statement statement = conn.createStatement();
	
	ResultSet result = statement.executeQuery(SQL);
	
	if(result.next())
		return true;
	else
		return false;
	
	
}

public static int getAnneeActuel() {
	
	Calendar calendar = Calendar.getInstance();
	
	return  calendar.get(Calendar.YEAR);
	
}

}
