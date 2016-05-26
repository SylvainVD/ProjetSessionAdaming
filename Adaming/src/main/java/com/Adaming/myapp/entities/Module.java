package com.Adaming.myapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Auteur : Sylvain VROLAND
 * Date : 25/05/2016
 * class : Module
 * package : com.Adaming.myapp.entities ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association :  / (uniderctionnelle : List<Session> ---> List<Module>)
 * */

@Entity
public class Module {
	
	// Attibuts
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idModule;
	private String nomModule;
	private int dureeModule;
	private String descriptionModule;

	// Associations

	// Getters & Setters
	
	public Long getIdModule() {
		return idModule;
	}
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	public String getNomModule() {
		return nomModule;
	}
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	public int getDureeModule() {
		return dureeModule;
	}
	public void setDureeModule(int dureeModule) {
		this.dureeModule = dureeModule;
	}
	public String getDescriptionModule() {
		return descriptionModule;
	}
	public void setDescriptionModule(String descriptionModule) {
		this.descriptionModule = descriptionModule;
	}

	// Constructeurs

	public Module(){
		
	}
	
	public Module(String nomModule, int dureeModule, String descriptionModule) {
		super();
		this.nomModule = nomModule;
		this.dureeModule = dureeModule;
		this.descriptionModule = descriptionModule;
	}

}
