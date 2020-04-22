package com.inscription.database;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.inscription.beans.Administration;
import com.inscription.beans.Departement;
import com.inscription.beans.Etudiant;
import com.inscription.beans.EtudiantProgress;
import com.inscription.beans.Inscription;
import com.inscription.webservice.ScolariteService;

public class TestDataBase {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		
		ScolariteService serv =  new ScolariteService(); 
		
		
		boolean result = serv.VerifierStatAnnee();
		
		System.out.println(result);
		
		
		
		
		
		
	}

}
