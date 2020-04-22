package com.adhesion.database;

import java.sql.SQLException;


public class TestDataBase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		AdhesionDataBase ad = new AdhesionDataBase();
		
		boolean res = ad.verifierDejaAdhesion(20151);
		
		System.out.println(res);
	
		
		
		

	}

}
