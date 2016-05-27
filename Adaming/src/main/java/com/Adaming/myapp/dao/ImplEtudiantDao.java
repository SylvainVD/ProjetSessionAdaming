package com.Adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Adaming.myapp.entities.Etudiant;
import com.Adaming.myapp.entities.Examen;
import com.Adaming.myapp.entities.Materiel;
import com.Adaming.myapp.entities.Session;
 
/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * class : ImplEtudiantDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Implements : InterfEtudiantDao */

public class ImplEtudiantDao implements InterfEtudiantDao {

	@PersistenceContext
	private EntityManager em;
	Logger log = Logger.getLogger("Impl�mentation Etudiant Dao");

	@Override
	public Etudiant addEtudiant(Etudiant et) {
		em.persist(et);
		log.info("L'�tudiant " + et.getNomEtudiant() + " "
				+ et.getPrenomEtudiant() + " " + et.getIdEtudiant()
				+ " a �t� cr��");
		;
		return et;
	}

	@Override
	public Etudiant getEtudiantById(Long id) {
		Etudiant et = em.find(Etudiant.class, id);
		log.info("Consultation de l'�tudiant " + et.getNomEtudiant() + " "
				+ et.getPrenomEtudiant() + " " + et.getIdEtudiant());
		;
		return et;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getEtudiantByMc(Long mc) {
		Query req = em.createQuery("from Etudiant where nomEtudiant like '%"
				+ mc + "%' or prenomEtudiant like '%" + mc + "%' ;");
		log.info("COnsultation d'une lise d'�tudiant par mot cl�");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiant() {
		Query req = em.createQuery("from Etudiant;");
		log.info("COnsultation de la liste de tous les �tudiants");
		return req.getResultList();
	}

	@Override
	public Etudiant deleteEtudiant(Long id) {
		Etudiant et = em.find(Etudiant.class, id);
		em.remove(et);
		log.info("L'�tudiant " + et.getNomEtudiant() + " "
				+ et.getPrenomEtudiant() + " " + et.getIdEtudiant()
				+ " a �t� supprim�");
		;
		return et;
	}

	@Override
	public Etudiant modifierEtudiant(Etudiant etudiant) {
		em.merge(etudiant);
		log.info("L'�tudiant " + etudiant.getNomEtudiant() + " "
				+ etudiant.getPrenomEtudiant() + " " + etudiant.getIdEtudiant()
				+ " a �t� modif�");
		;
		return etudiant;
	}

	@Override
	public Etudiant addEtudiantToSession(Long idEtudiant, Long idSession) {
		Session se = em.find(Session.class, idSession);
		Etudiant et = em.find(Etudiant.class, idEtudiant);
		et.setSessionDeLEtudiant(se);
		em.merge(et);
		return et;
	}

	@Override
	public Etudiant addMaterielToEtudiant(Long idEtudiant, Long idMateriel) {
		Materiel ma = em.find(Materiel.class, idMateriel);
		Etudiant et = em.find(Etudiant.class, idEtudiant);
		et.getListeMaterielDeLEtudiant().add(ma);
		em.merge(et);
		log.info("Ajout du mat�riel " + ma.getNomMateriel() + " "
				+ ma.getIdMateriel() + " � l'�tudiant " + et.getNomEtudiant()
				+ " " + et.getPrenomEtudiant() + " " + et.getIdEtudiant());
		;
		return et;
	}

	@Override
	public List<Materiel> listeMaterielDUnEtudiant(Long idEtudiant) {
		Etudiant etud = em.find(Etudiant.class, idEtudiant);
		log.info("Consultation de la liste de mat�riels de l'�tudiant "
				+ etud.getNomEtudiant() + " " + etud.getPrenomEtudiant() + " "
				+ etud.getIdEtudiant() + " a �t� cr��");
		return etud.getListeMaterielDeLEtudiant();
	}

	@Override
	public List<Examen> listeExamDUnEtudiant(Long idEtudiant) {
		Etudiant etud = em.find(Etudiant.class, idEtudiant);
		log.info("Consultation de la liste d'examens de l'�tudiant "
				+ etud.getNomEtudiant() + " " + etud.getPrenomEtudiant() + " "
				+ etud.getIdEtudiant() + " a �t� cr��");
		return etud.getListeExamenDeLEtudiant();
	}

	@Override
	public double moyenneDUnEtudiant(Long idEtudiant) {
		Double req = (Double) em.createQuery(
				"select avg(noteExamen) from Examen where etudiantDeLExamen = "
						+ idEtudiant).getSingleResult();
		Etudiant etud = em.find(Etudiant.class, idEtudiant);
		log.info("Calcul de la moyenne de l'�tudiant " + etud.getNomEtudiant()
				+ " " + etud.getPrenomEtudiant() + " " + etud.getIdEtudiant()
				+ " a �t� cr��");
		return req;
	}

}
