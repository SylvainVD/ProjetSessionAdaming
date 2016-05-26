package com.Adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * Auteur : Sylvain VROLAND
 * Date : 25/05/2016
 * class : Session
 * package : com.Adaming.myapp.entities ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association : 	OneToMany avec List<Etudiant>,
 * 					ManyToOne avec Salle,
 * 					unidirectionnelle ManytoMany avec Module (Session ---> Module)
 * */

@SuppressWarnings("serial")
@Entity
public class Session implements Serializable{

	// Attibuts
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSession;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date dateDebSession;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date dateFinSession;
	private String nomSession;

	// Associations
	@OneToMany(mappedBy="sessionDeLEtudiant")
	private List<Etudiant> listeEtudiantDeLaSession = new ArrayList<Etudiant>();
	@ManyToOne
	@JoinColumn
	private Salle salleDeLaSession;
	@ManyToMany //unidirectionnel
	//@JoinTable
	private List<Module> listeModuleDeLaSession = new ArrayList<Module>();
	

	// Getters & Setters
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	public Date getDateDebSession() {
		return dateDebSession;
	}
	public void setDateDebSession(Date dateDebSession) {
		this.dateDebSession = dateDebSession;
	}
	public Date getDateFinSession() {
		return dateFinSession;
	}
	public void setDateFinSession(Date dateFinSession) {
		this.dateFinSession = dateFinSession;
	}
	public String getNomSession() {
		return nomSession;
	}
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}
	public List<Etudiant> getListeEtudiantDeLaSession() {
		return listeEtudiantDeLaSession;
	}
	public void setListeEtudiantDeLaSession(List<Etudiant> listeEtudiantDeLaSession) {
		this.listeEtudiantDeLaSession = listeEtudiantDeLaSession;
	}
	public Salle getSalleDeLaSession() {
		return salleDeLaSession;
	}
	public void setSalleDeLaSession(Salle salleDeLaSession) {
		this.salleDeLaSession = salleDeLaSession;
	}
	public List<Module> getListeModuleDeLaSession() {
		return listeModuleDeLaSession;
	}
	public void setListeModuleDeLaSession(List<Module> listeModuleDeLaSession) {
		this.listeModuleDeLaSession = listeModuleDeLaSession;
	}
	// Constructeurs
	public Session(Date dateDebSession, Date dateFinSession, String nomSession) {
		this.dateDebSession = dateDebSession;
		this.dateFinSession = dateFinSession;
		this.nomSession = nomSession;
	}
	public Session() {
	}
	
}
