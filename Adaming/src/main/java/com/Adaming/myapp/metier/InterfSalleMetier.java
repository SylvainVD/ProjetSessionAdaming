package com.Adaming.myapp.metier;

import java.util.List;

import com.Adaming.myapp.entities.Salle;

/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Interface : InterfSalleMetier
 * package : com.Adaming.myapp.Metier ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public interface InterfSalleMetier {
	public Salle addSalle(Salle s);
	public Salle modifySalle(Long idSalle);
	public Salle deleteSalle(Long idSalle);
	public Salle getSalle(Long idSalle);
	public List<Salle> getListSalle();
	public List<Salle> getListSallebyMC(String MC);
}
