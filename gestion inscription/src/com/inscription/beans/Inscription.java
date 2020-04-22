package com.inscription.beans;

public class Inscription {
	
	private int id ;
	
	private Etudiant etudiant;
	
	private Administration agent;
	
	private String annee_universitaire;
	
	private String niveau ;
	
	public Inscription() {
		
		
	}
	
	

	public Inscription(int id, Etudiant etudiant, 
			Administration agent, String annee_universitaire , String niveau) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.agent = agent;
		this.annee_universitaire = annee_universitaire;
		this.niveau = niveau;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Administration getAgent() {
		return agent;
	}

	public void setAgent(Administration agent) {
		this.agent = agent;
	}



	public String getAnnee_universitaire() {
		return annee_universitaire;
	}



	public void setAnnee_universitaire(String annee_universitaire) {
		this.annee_universitaire = annee_universitaire;
	}



	public String getNiveau() {
		return niveau;
	}



	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	
	
	
	
	

}
