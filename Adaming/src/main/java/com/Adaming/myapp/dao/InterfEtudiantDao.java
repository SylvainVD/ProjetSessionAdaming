package com.Adaming.myapp.dao;

/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * Interface : InterfEtudiantDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */

import java.util.List;

import com.Adaming.myapp.entities.Etudiant;
import com.Adaming.myapp.entities.Examen;
import com.Adaming.myapp.entities.Materiel;

public interface InterfEtudiantDao {

	// Liste des méthodes liées à la class Etudiant :

	public Etudiant addEtudiant(Etudiant et);

	public Etudiant getEtudiantById(Long id);

	public List<Etudiant> getEtudiantByMc(Long mc);

	public List<Etudiant> getAllEtudiant();

	public Etudiant deleteEtudiant(Long id);

	public Etudiant modifierEtudiant(Etudiant etudiant);

	public Etudiant addEtudiantToSession(Long idEtudiant, Long idSession);
	
	public Etudiant addMaterielToEtudiant(Long idEtudiant, Long idMateriel);
	
	public List<Materiel> listeMaterielDUnEtudiant(Long idEtudiant);
	
	public List<Examen> listeExamDUnEtudiant(Long idEtudiant);
	
	public double moyenneDUnEtudiant(Long idEtudiant);
	

}
