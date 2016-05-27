package com.Adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Adaming.myapp.entities.Materiel;

/* 
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * class : ImplMaterielDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Implements : InterfMaterielDao */

public class ImplMaterielDao implements InterfMaterielDao {

	@PersistenceContext
	private EntityManager em;
	Logger log = Logger.getLogger("Implémentation Materiel dao");

	@Override
	public Materiel addMateriel(Materiel ma) {
		em.persist(ma);
		log.info("Le matériel " + ma.getNomMateriel() + " "
				+ ma.getIdMateriel() + " a été créé.");
		return ma;
	}

	@Override
	public Materiel getMaterielById(Long id) {
		Materiel ma = em.find(Materiel.class, id);
		log.info("Consultation du matériel " + ma.getNomMateriel() + " "
				+ ma.getIdMateriel() + " a été créé.");
		return ma;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materiel> getAllMateriel() {
		Query req = em.createQuery("from Materiel ;");
		log.info("Consultation de la liste de matériel");
		return req.getResultList();
	}

	@Override
	public Materiel deleteMateriel(Long id) {
		Materiel ma = em.find(Materiel.class, id);
		em.remove(ma);
		log.info("Le matériel " + ma.getNomMateriel() + " "
				+ ma.getIdMateriel() + " a été supprimé.");
		return ma;
	}

	@Override
	public Materiel updateMateriel(Materiel ma) {
		em.merge(ma);
		log.info("Le matériel " + ma.getNomMateriel() + " "
				+ ma.getIdMateriel() + " a été modifié.");
		return ma;
	}

}
