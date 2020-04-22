package com.inscription.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.inscription.beans.Etudiant;
import com.inscription.beans.EtudiantProgress;

public class ProgressDataBase {
	
	private static  String dbURL = "jdbc:mysql://localhost:3306/progress";
	private static  String username = "root";
	private static  String password = "aymen1234";
	
	private Connection conn ;
	
	public ProgressDataBase() throws ClassNotFoundException, SQLException {
		
		conn = InisialiserConnection();
	}
	
	
public static   Connection InisialiserConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection(  
		dbURL,username,password);
		
		return conn;
		
	}



	public EtudiantProgress ChercherEtudiant(int id ) throws SQLException {
		
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
			String niveau = result.getString(9);
			String filiere = result.getString(10);
			
			
			EtudiantProgress etudiant = new EtudiantProgress(idEtudiant, nom, prenom, date_naissance, lieu_naissance, sexe,
					telephone, adresse,filiere, niveau);
			conn.close();
			statement.close();
			result.close();
			return etudiant;
		}
		
		return null;
	}

}
