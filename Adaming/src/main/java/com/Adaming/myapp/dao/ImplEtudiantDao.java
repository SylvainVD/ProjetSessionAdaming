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
	Logger log = Logger.getLogger("Implémentation Etudiant Dao");

	@Override
	public Etudiant addEtudiant(Etudiant et) {
		em.persist(et);
		log.info("L'étudiant " + et.getNomEtudiant() + " "
				+ et.getPrenomEtudiant() + " " + et.getIdEtudiant()
				+ " a été créé");
		;
		return et;
	}

	@Override
	public Etudiant getEtudiantById(Long id) {
		Etudiant et = em.find(Etudiant.class, id);
		log.info("Consultation de l'étudiant " + et.getNomEtudiant() + " "
				+ et.getPrenomEtudiant() + " " + et.getIdEtudiant());
		;
		return et;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getEtudiantByMc(Long mc) {
		Query req = em.createQuery("from Etudiant where nomEtudiant like '%"
				+ mc + "%' or prenomEtudiant like '%" + mc + "%' ;");
		log.info("COnsultation d'une lise d'étudiant par mot clé");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiant() {
		Query req = em.createQuery("from Etudiant;");
		log.info("COnsultation de la liste de tous les étudiants");
		return req.getResultList();
	}

	@Override
	public Etudiant deleteEtudiant(Long id) {
		Etudiant et = em.find(Etudiant.class, id);
		em.remove(et);
		log.info("L'étudiant " + et.getNomEtudiant() + " "
				+ et.getPrenomEtudiant() + " " + et.getIdEtudiant()
				+ " a été supprimé");
		;
		return et;
	}

	@Override
	public Etudiant modifierEtudiant(Etudiant etudiant) {
		em.merge(etudiant);
		log.info("L'étudiant " + etudiant.getNomEtudiant() + " "
				+ etudiant.getPrenomEtudiant() + " " + etudiant.getIdEtudiant()
				+ " a été modifé");
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
		log.info("Ajout du matériel " + ma.getNomMateriel() + " "
				+ ma.getIdMateriel() + " à l'étudiant " + et.getNomEtudiant()
				+ " " + et.getPrenomEtudiant() + " " + et.getIdEtudiant());
		;
		return et;
	}

	@Override
	public List<Materiel> listeMaterielDUnEtudiant(Long idEtudiant) {
		Etudiant etud = em.find(Etudiant.class, idEtudiant);
		log.info("Consultation de la liste de matériels de l'étudiant "
				+ etud.getNomEtudiant() + " " + etud.getPrenomEtudiant() + " "
				+ etud.getIdEtudiant() + " a été créé");
		return etud.getListeMaterielDeLEtudiant();
	}

	@Override
	public List<Examen> listeExamDUnEtudiant(Long idEtudiant) {
		Etudiant etud = em.find(Etudiant.class, idEtudiant);
		log.info("Consultation de la liste d'examens de l'étudiant "
				+ etud.getNomEtudiant() + " " + etud.getPrenomEtudiant() + " "
				+ etud.getIdEtudiant() + " a été créé");
		return etud.getListeExamenDeLEtudiant();
	}

	@Override
	public double moyenneDUnEtudiant(Long idEtudiant) {
		Double req = (Double) em.createQuery(
				"select avg(noteExamen) from Examen where etudiantDeLExamen = "
						+ idEtudiant).getSingleResult();
		Etudiant etud = em.find(Etudiant.class, idEtudiant);
		log.info("Calcul de la moyenne de l'étudiant " + etud.getNomEtudiant()
				+ " " + etud.getPrenomEtudiant() + " " + etud.getIdEtudiant()
				+ " a été créé");
		return req;
	}

}
