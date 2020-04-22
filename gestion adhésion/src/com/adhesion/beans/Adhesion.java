package com.adhesion.beans;

import com.scolarite.webservice.ScolariteServiceStub.Etudiant;

public class Adhesion {
	
	
	private int id  ;
	
	private Etudiant etudiant ;
	
	private int idAgent ;
	
	private int annee_univ ;
	
	
	public Adhesion() {
		
	}


	public Adhesion(int id, Etudiant idEtudiant, int idAgent, int annee_univ) {
		super();
		this.id = id;
		this.etudiant = idEtudiant;
		this.idAgent = idAgent;
		this.annee_univ = annee_univ;
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


	public void setIdEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public int getIdAgent() {
		return idAgent;
	}


	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}


	public int getAnnee_univ() {
		return annee_univ;
	}


	public void setAnnee_univ(int annee_univ) {
		this.annee_univ = annee_univ;
	}
	
	

}
