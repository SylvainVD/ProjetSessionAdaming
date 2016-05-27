package com.Adaming.myapp.metier;

import java.util.List;

import com.Adaming.myapp.entities.Etudiant;
import com.Adaming.myapp.entities.Examen;
import com.Adaming.myapp.entities.Materiel;

public interface InterfEtudiantMetier {
	
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
