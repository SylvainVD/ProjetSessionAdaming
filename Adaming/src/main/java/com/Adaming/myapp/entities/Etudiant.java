package com.Adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * Auteur : Sylvain VROLAND
 * Date : 25/05/2016
 * class : Etudiant
 * package : com.Adaming.myapp.entities ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association :  	OneToMany unidirectionnelle avec List<Materiel>, 
 * 					OneToMany avec List<Exament>, 
 * 					ManyToOne avec Session;
 * */
 
@SuppressWarnings("serial")
@Entity
public class Etudiant implements Serializable {

	// Attibuts
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceEtudiant;
	private String numTelephoneEtudiant;
	private String mailEtudiant;
	private String specialiteEtudiant;
	private String adresseEtudiant;

	// Associations
	@OneToMany
	// unidirectionnel
	// @JoinColumn
	private List<Materiel> listeMaterielDeLEtudiant = new ArrayList<Materiel>();
	@OneToMany(mappedBy = "etudiantDeLExamen",fetch=FetchType.EAGER)
	private List<Examen> listeExamenDeLEtudiant = new ArrayList<Examen>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Session sessionDeLEtudiant;

	// Getters & Setters

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public Date getDateNaissanceEtudiant() {
		return dateNaissanceEtudiant;
	}

	public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	public String getNumTelephoneEtudiant() {
		return numTelephoneEtudiant;
	}

	public void setNumTelephoneEtudiant(String numTelephoneEtudiant) {
		this.numTelephoneEtudiant = numTelephoneEtudiant;
	}

	public String getMailEtudiant() {
		return mailEtudiant;
	}

	public void setMailEtudiant(String mailEtudiant) {
		this.mailEtudiant = mailEtudiant;
	}

	public String getSpecialiteEtudiant() {
		return specialiteEtudiant;
	}

	public void setSpecialiteEtudiant(String specialiteEtudiant) {
		this.specialiteEtudiant = specialiteEtudiant;
	}

	public String getAdresseEtudiant() {
		return adresseEtudiant;
	}

	public void setAdresseEtudiant(String adresseEtudiant) {
		this.adresseEtudiant = adresseEtudiant;
	}

	public List<Materiel> getListeMaterielDeLEtudiant() {
		return listeMaterielDeLEtudiant;
	}

	public void setListeMaterielDeLEtudiant(
			List<Materiel> listeMaterielDeLEtudiant) {
		this.listeMaterielDeLEtudiant = listeMaterielDeLEtudiant;
	}

	public List<Examen> getListeExamenDeLEtudiant() {
		return listeExamenDeLEtudiant;
	}

	public void setListeExamenDeLEtudiant(List<Examen> listeExamenDeLEtudiant) {
		this.listeExamenDeLEtudiant = listeExamenDeLEtudiant;
	}

	public Session getSessionDeLEtudiant() {
		return sessionDeLEtudiant;
	}

	public void setSessionDeLEtudiant(Session sessionDeLEtudiant) {
		this.sessionDeLEtudiant = sessionDeLEtudiant;
	}

	// Constructeurs

	public Etudiant() {

	}

	public Etudiant(String nomEtudiant, String prenomEtudiant,
			Date dateNaissanceEtudiant, String numTelephoneEtudiant,
			String mailEtudiant, String specialiteEtudiant,
			String adresseEtudiant) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
		this.numTelephoneEtudiant = numTelephoneEtudiant;
		this.mailEtudiant = mailEtudiant;
		this.specialiteEtudiant = specialiteEtudiant;
		this.adresseEtudiant = adresseEtudiant;
	}

}
