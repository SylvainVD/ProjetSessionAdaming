package com.Adaming.myapp.metier;

import java.util.List;

import com.Adaming.myapp.entities.Examen;

public interface InterfExamenMetier {
	
	public Examen addExamen(Examen exam, Long idEtudiant);

	public Examen getExamen(Long id);

	public List<Examen> getAllExamen();

	public Examen updateExamen(Examen exam);

	public Examen deleteExamen(Long id);

	/*public Examen addExamenToEtudiant(Long idexam, Long idEtud);*/

}
