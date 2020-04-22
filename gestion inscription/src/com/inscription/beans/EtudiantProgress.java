package com.inscription.beans;

public class EtudiantProgress {
	
	
	private int id;
	private String nom;
	private String prenom;
	private String dataNaissance;
	private String lieuNaissance;
	private String sexe;
	private String telephone;
	private String asresse;
	private String filiere;
	private String niveau_actuel ;
	
	
	public EtudiantProgress() {
		
		
	}

	
	

	public EtudiantProgress(int id, String nom, String prenom, String dataNaissance,
			String lieuNaissance, String sexe,
			String telephone, String asresse, String filiere, String niveau_actuel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dataNaissance = dataNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.telephone = telephone;
		this.asresse = asresse;
		this.filiere = filiere;
		this.niveau_actuel = niveau_actuel;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getDataNaissance() {
		return dataNaissance;
	}


	public void setDataNaissance(String dataNaissance) {
		this.dataNaissance = dataNaissance;
	}


	public String getLieuNaissance() {
		return lieuNaissance;
	}


	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAsresse() {
		return asresse;
	}


	public void setAsresse(String asresse) {
		this.asresse = asresse;
	}


	public String getFiliere() {
		return filiere;
	}


	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}


	public String getNiveau_actuel() {
		return niveau_actuel;
	}


	public void setNiveau_actuel(String niveau_actuel) {
		this.niveau_actuel = niveau_actuel;
	}
	
	

}
