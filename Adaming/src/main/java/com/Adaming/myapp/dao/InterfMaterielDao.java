package com.Adaming.myapp.dao;

/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * Interface : InterfMaterielDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */

import java.util.List;

import com.Adaming.myapp.entities.Materiel;

public interface InterfMaterielDao {

	public Materiel addMateriel(Materiel ma);

	public Materiel getMaterielById(Long id);

	public List<Materiel> getAllMateriel();

	public Materiel deleteMateriel(Long id);

	public Materiel updateMateriel(Materiel ma);
 
}
