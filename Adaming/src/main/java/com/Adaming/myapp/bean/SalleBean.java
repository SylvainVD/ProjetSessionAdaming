package com.Adaming.myapp.bean;

import java.util.List;

import javax.faces.bean.RequestScoped;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
/*Auteur: Arnaud MARY
 * nom Projet: Adaming
 *date : 27/05/2016
 *Package: com.Adaming.myapp.bean
 *Class: SalleBean
 *version:1.0
 * 
 * */


import com.Adaming.myapp.entities.Salle;
import com.Adaming.myapp.metier.InterfSalleMetier;
@Controller
@Component(value="salleBean")
@RequestScoped
public class SalleBean {
	@Autowired
	private InterfSalleMetier salleMetier;
	
	private static Logger Log = Logger.getLogger("Logger Salle Bean");
	
	private Long idSalle;
	private String adresseSalle;
	private int numSalle;
	private int capaciteSalle;
	private List<Salle> tab;
	private List<Salle> recherche;
	private String mc;
	private Salle salle = new Salle();
	private Salle salledel = new Salle();
	private Salle salleup = new Salle();
	private Salle salleR = new Salle();
	
	// Getters and Setters
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
	public List<Salle> getTab() {
		return tab;
	}
	public void setTab(List<Salle> tab) {
		this.tab = tab;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Salle getSalledel() {
		return salledel;
	}
	public void setSalledel(Salle salledel) {
		this.salledel = salledel;
	}
	public List<Salle> getRecherche() {
		return recherche;
	}
	public void setRecherche(List<Salle> recherche) {
		this.recherche = recherche;
	}
	public Salle getSalleR() {
		return salleR;
	}
	public void setSalleR(Salle salleR) {
		this.salleR = salleR;
	}
	// Methodes
	public List<Salle> getListSalle(){
		Log.info("Debut getListSalle");
		tab = salleMetier.getListSalle();
		return tab;
	}
	public List<Salle> getListSallebyMC(String mc){
		Log.info("Debut getListSalle par mot clé");
		recherche = salleMetier.getListSallebyMC(mc);
		return recherche;
	}
	public Salle getSalleup() {
		return salleup;
	}
	public void setSalleup(Salle salleup) {
		this.salleup = salleup;
	}
	public Salle addSalle(String adresseSalle, Integer numSalle, Integer capaciteSalle){
		Log.info("Debut add Salle avec adr :"+adresseSalle +" avec num : "+numSalle +" avec capacite : "+capaciteSalle);
		Salle s = new Salle();
		s.setAdresseSalle(adresseSalle);
		s.setCapaciteSalle(capaciteSalle);
		s.setNumSalle(numSalle);
		salle = salleMetier.addSalle(s);
		
		return salle;
	}
	public Salle modifySalle(Long idSalle, String adSall, Integer numSall, Integer capaSall){
		Log.info("Debut modifier Salle avec adresse : "+adSall +" numéro : "+numSall +"capacité : "+capaSall);
		Salle sal = new Salle();
		if (idSalle != null){
			sal.setIdSalle(idSalle);
		}
		if (adSall != null){
			sal.setAdresseSalle(adSall);
		}
		if (numSall != null){
			sal.setNumSalle(numSall);
		}
		if (capaSall != null){
			sal.setCapaciteSalle(capaSall);
		}
		salleup = salleMetier.modifySalle(sal);
		return salleup;
	}
	public Salle deleteSalle(Long idSalle){
		Log.info("Debut delete Salle id : "+idSalle);
		Salle sallesup = new Salle();
		sallesup= salleMetier.deleteSalle(idSalle);
		salledel = sallesup;
		return salledel;
	}
	public Salle get1Salle(Long idSalle){
		Log.info("Debut récup 1 salle id : "+idSalle);
		Salle sid = new Salle();
		sid = salleMetier.getSalle(idSalle);
		salleR = sid;
		return salleR;
	}
	
}
