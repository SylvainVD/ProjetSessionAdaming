package com.Adaming.myapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Auteur : Sylvain VROLAND
 * Date : 25/05/2016
 * class : Materiel
 * package : com.Adaming.myapp.entities ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association : / (unidirectionnelle : Etudiant ---> List<Materiel>)
 * */

@Entity
public class Materiel {
	
	// Attibuts
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMateriel;
	private String nomMateriel;
	private String etatMateriel; //{"Neuf", "Très Bon", "Bon", "Passable", "Usée", "Inutilisable"}
	
	// Associations

	// Getters & Setters
	
	public Long getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(Long idMateriel) {
		this.idMateriel = idMateriel;
	}
	public String getNomMateriel() {
		return nomMateriel;
	}
	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}
	public String getEtatMateriel() {
		return etatMateriel;
	}
	public void setEtatMateriel(String etatMateriel) {
		this.etatMateriel = etatMateriel;
	}

	// Constructeurs
	
	public Materiel(){
		
	}
	
	public Materiel(String nomMateriel, String etatMateriel) {
		super();
		this.nomMateriel = nomMateriel;
		this.etatMateriel = etatMateriel;
	}

}
