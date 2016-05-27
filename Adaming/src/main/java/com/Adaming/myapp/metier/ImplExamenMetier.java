package com.Adaming.myapp.metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.Adaming.myapp.dao.InterfExamenDao;
import com.Adaming.myapp.entities.Examen;

/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * interface : ImplExamenMetier ;
 * package : com.Adaming.myapp.metier ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Imterface impl�ment�e : InterfExamenMetier ;
 * Class concern�e : Examen
 * */
 
@Transactional
public class ImplExamenMetier implements InterfExamenMetier{
	
	private final Logger log = Logger.getLogger("Impl�mentation Examen M�tier !!!");
	private InterfExamenDao dao;
	
	public void setDao(InterfExamenDao dao) {
		this.dao = dao;
		log.info("Dao Examen inject� dans le M�tier !!!");
	}

	@Override
	public Examen addExamen(Examen exam, Long idEtudiant) {
		return dao.addExamen(exam, idEtudiant);
	}

	@Override
	public Examen getExamen(Long id) {
		return dao.getExamen(id);
	}

	@Override
	public List<Examen> getAllExamen() {
		return dao.getAllExamen();
	}

	@Override
	public Examen updateExamen(Examen exam) {
		return dao.updateExamen(exam);
	}

	@Override
	public Examen deleteExamen(Long id) {
		return dao.deleteExamen(id);
	}

	/*@Override
	public Examen addExamenToEtudiant(Long idexam, Long idEtud) {
		return dao.addExamenToEtudiant(idexam, idEtud);
	}*/

}
