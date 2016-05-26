package com.Adaming.myapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * Auteur : Sylvain VROLAND
 * Date : 25/05/2016
 * class : Salle
 * package : com.Adaming.myapp.entities ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association : OneToMany avec List<Session>;
 * */

@Entity
public class Salle {
	
	
	// Attibuts
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSalle;
	private String adresseSalle;
	private int numSalle;
	private int capaciteSalle;

	
	// Associations
	
	@OneToMany(mappedBy="salleDeLaSession")
	private List<Session> listeSessionDeLaSalle = new ArrayList<Session>();

	
	// Getters & Setters
	
	public Long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}

	public String getAdresseSalle() {
		return adresseSalle;
	}

	public void setAdresseSalle(String adresseSalle) {
		this.adresseSalle = adresseSalle;
	}

	public int getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	public int getCapaciteSalle() {
		return capaciteSalle;
	}

	public void setCapaciteSalle(int capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}

	public List<Session> getListeSessionDeLaSalle() {
		return listeSessionDeLaSalle;
	}

	public void setListeSessionDeLaSalle(List<Session> listeSessionDeLaSalle) {
		this.listeSessionDeLaSalle = listeSessionDeLaSalle;
	}

	// Constructeurs

	public Salle(){
		
	}

	public Salle(String adresseSalle, int numSalle, int capaciteSalle) {
		super();
		this.adresseSalle = adresseSalle;
		this.numSalle = numSalle;
		this.capaciteSalle = capaciteSalle;
	}
	
	
}
