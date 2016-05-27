package com.Adaming.myapp.metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.Adaming.myapp.dao.InterfEtudiantDao;
import com.Adaming.myapp.entities.Etudiant;
import com.Adaming.myapp.entities.Examen;
import com.Adaming.myapp.entities.Materiel;

/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * interface : ImplEtudiantMetier ;
 * package : com.Adaming.myapp.metier ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Imterface implémentée : InterfEtudiantMetier ;
 * Class concernée : Etudiant
 * */
 
@Transactional
public class ImplEtudiantMetier implements InterfEtudiantMetier{
	
	private final Logger log = Logger.getLogger("Implémentation Etudiant Métier !!!");
	private InterfEtudiantDao dao;

	public void setDao(InterfEtudiantDao dao) {
		this.dao = dao;
		log.info("Dao Etudiant injecté dans le Métier !!!");
	}

	@Override
	public Etudiant addEtudiant(Etudiant et) {
		return dao.addEtudiant(et);
	}

	@Override
	public Etudiant getEtudiantById(Long id) {
		return dao.getEtudiantById(id);
	}

	@Override
	public List<Etudiant> getEtudiantByMc(Long mc) {
		return dao.getEtudiantByMc(mc);
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		return dao.getAllEtudiant();
	}

	@Override
	public Etudiant deleteEtudiant(Long id) {
		return dao.deleteEtudiant(id);
	}

	@Override
	public Etudiant modifierEtudiant(Etudiant etudiant) {
		return dao.modifierEtudiant(etudiant);
	}

	@Override
	public Etudiant addEtudiantToSession(Long idEtudiant, Long idSession) {
		return dao.addEtudiantToSession(idEtudiant, idSession);
	}

	@Override
	public Etudiant addMaterielToEtudiant(Long idEtudiant, Long idMateriel) {
		return dao.addMaterielToEtudiant(idEtudiant, idMateriel);
	}

	@Override
	public List<Materiel> listeMaterielDUnEtudiant(Long idEtudiant) {
		return dao.listeMaterielDUnEtudiant(idEtudiant);
	}

	@Override
	public List<Examen> listeExamDUnEtudiant(Long idEtudiant) {
		return dao.listeExamDUnEtudiant(idEtudiant);
	}

	@Override
	public double moyenneDUnEtudiant(Long idEtudiant) {
		return dao.moyenneDUnEtudiant(idEtudiant);
	}
	
}
