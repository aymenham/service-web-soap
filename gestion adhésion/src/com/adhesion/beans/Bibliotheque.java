package com.adhesion.beans;

public class Bibliotheque {
	
	private String annee_univ;
	
	private String stat_adhesion ;
	
	public Bibliotheque() {
		
	}

	public Bibliotheque(String annee_univ, String stat_adhesion) {
		super();
		this.annee_univ = annee_univ;
		this.stat_adhesion = stat_adhesion;
	}

	public String getAnnee_univ() {
		return annee_univ;
	}

	public void setAnnee_univ(String annee_univ) {
		this.annee_univ = annee_univ;
	}

	public String getStat_adhesion() {
		return stat_adhesion;
	}

	public void setStat_adhesion(String stat_adhesion) {
		this.stat_adhesion = stat_adhesion;
	}
	
	
	
	

}
