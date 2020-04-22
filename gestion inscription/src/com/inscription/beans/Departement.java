package com.inscription.beans;

public class Departement {
	
	private String anneeUniversitaire;
	
	private String  statutAnne;
	
	private String statutInscription;

	
	public Departement() {
		
	}
	
	public Departement(String anneeUniversitaire, String statutAnne, String statutInscription) {
		super();
		this.anneeUniversitaire = anneeUniversitaire;
		this.statutAnne = statutAnne;
		this.statutInscription = statutInscription;
	}

	public String getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public String getStatutAnne() {
		return statutAnne;
	}

	public void setStatutAnne(String statutAnne) {
		this.statutAnne = statutAnne;
	}

	public String getStatutInscription() {
		return statutInscription;
	}

	public void setStatutInscription(String statutInscription) {
		this.statutInscription = statutInscription;
	}
	
	
	
	

}
