package com.Adaming.myapp.dao;

import java.util.List;

import com.Adaming.myapp.entities.Examen;

/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * Interface : InterfExamenDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
 
public interface InterfExamenDao {

	public Examen addExamen(Examen exam, Long idEtud);

	public Examen getExamen(Long id);

	public List<Examen> getAllExamen();

	public Examen updateExamen(Examen exam);

	public Examen deleteExamen(Long id);

}
