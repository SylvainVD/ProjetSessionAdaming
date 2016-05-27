package com.Adaming.myapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * Auteur : Sylvain VROLAND
 * Date : 25/05/2016
 * class : Examen
 * package : com.Adaming.myapp.entities ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association : ManyToOne avec Etudiant;
 * */
 
@SuppressWarnings("serial")
@Entity
public class Examen implements Serializable {
	
	// Attibuts
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExamen;
	private String intituleExamen;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date dateExamen;
	private Double noteExamen;

	// Associations
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private Etudiant etudiantDeLExamen;

	// Getters & Setters

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public String getIntituleExamen() {
		return intituleExamen;
	}

	public void setIntituleExamen(String intituleExamen) {
		this.intituleExamen = intituleExamen;
	}

	public Date getDateExamen() {
		return dateExamen;
	}

	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}

	public Double getNoteExamen() {
		return noteExamen;
	}

	public void setNoteExamen(Double noteExamen) {
		this.noteExamen = noteExamen;
	}

	public Etudiant getEtudiantDeLExamen() {
		return etudiantDeLExamen;
	}

	public void setEtudiantDeLExamen(Etudiant etudiantDeLExamen) {
		this.etudiantDeLExamen = etudiantDeLExamen;
	}

	// Constructeurs
	
	public Examen(){
		
	}
	
	public Examen(String intituleExamen, Date dateExamen, Double noteExamen) {
		super();
		this.intituleExamen = intituleExamen;
		this.dateExamen = dateExamen;
		this.noteExamen = noteExamen;
	}

}
