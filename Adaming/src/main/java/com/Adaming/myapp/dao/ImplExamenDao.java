package com.Adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Adaming.myapp.entities.Etudiant;
import com.Adaming.myapp.entities.Examen;

/* 
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * Interface : ImplExamenDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Implements : InterfExamenDao */

public class ImplExamenDao implements InterfExamenDao {

	@PersistenceContext
	private EntityManager em;
	Logger log = Logger.getLogger("Implémentation Examen dao !!!");

	@Override
	public Examen addExamen(Examen exam, Long idEtudiant) {
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		exam.setEtudiantDeLExamen(e);
		em.persist(exam);
		log.info("L'examen " + exam.getIntituleExamen() + " "
				+ exam.getIdExamen() + " a été créé");
		e.getListeExamenDeLEtudiant().add(exam);
		em.merge(e);
		return exam;
	}

	@Override
	public Examen getExamen(Long id) {
		Examen exam = em.find(Examen.class, id);
		log.info("Consultation de l'examen " + exam.getIntituleExamen() + " "
				+ exam.getIdExamen());
		return exam;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Examen> getAllExamen() {
		Query req = em.createQuery("from Examen");
		log.info("Consultation de la liste de tous les examens");
		return req.getResultList();
	}

	@Override
	public Examen updateExamen(Examen exam) {
		em.merge(exam);
		log.info("L'examen " + exam.getIntituleExamen() + " "
				+ exam.getIdExamen() + " a été modifié");
		return exam;
	}

	@Override
	public Examen deleteExamen(Long id) {
		Examen exam = em.find(Examen.class, id);
		em.remove(exam);
		log.info("L'examen " + exam.getIntituleExamen() + " "
				+ exam.getIdExamen() + " a été supprimé");
		return exam;
	}
/*
	@Override
	public Examen addExamenToEtudiant(Long idexam, Long idEtud) {
		Examen exam = em.find(Examen.class, idexam);
		Etudiant etud = em.find(Etudiant.class, idEtud);
		exam.setEtudiantDeLExamen(etud);
		log.info("L'examen " + exam.getIntituleExamen() + " "
				+ exam.getIdExamen() + " a été ajouté à l'étudiant "
				+ etud.getNomEtudiant() + " " + etud.getPrenomEtudiant() + " "
				+ etud.getIdEtudiant());
		return exam;
	}*/

}
