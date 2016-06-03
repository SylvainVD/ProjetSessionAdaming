package com.Adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Adaming.myapp.entities.Salle;

/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Interface : ImplSalleDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public class ImplSalleDao implements InterfSalleDao{
	private static Logger Log = Logger.getLogger("DAO Salle");
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Salle addSalle(Salle s) {
		Log.info("Debut add salle : id salle : "+s.getIdSalle());
		em.persist(s);
		Log.info("Fin add salle : id salle : "+s.getIdSalle());
		return s;
	}

	@Override
	public Salle modifySalle(Salle sal) {
		Log.info("Debut modify salle : id salle : "+sal.getIdSalle());
		em.merge(sal);
		Log.info("Fin modify salle : id salle : "+sal.getIdSalle());
		return sal;
	}

	@Override
	public Salle deleteSalle(Long idSalle) {
		Log.info("Debut delete salle : id salle : "+idSalle);
		Salle s = em.find(Salle.class, idSalle);
		em.remove(s);
		Log.info("Fin delete salle : id salle : "+s.getIdSalle());
		return s;
	}

	@Override
	public Salle getSalle(Long idSalle) {
		Log.info("Debut getSalle salle : id salle : "+idSalle);
		Salle s = em.find(Salle.class, idSalle);
		Log.info("Fin getSalle salle : num salle : "+s.getNumSalle());
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> getListSalle() {
		Log.info("Debut getListSalle");
		Query req = em.createQuery("Select s from Salle s");
		Log.info("Nombre de salles dans la liste : "+req.getResultList().size());
		return req.getResultList();
	}
// Recherche des salles à partir de leur adresse.
	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> getListSallebyMC(String MC) {
		Log.info("Debut getList salle par mot clé : "+MC);
		Query req = em.createQuery("Select s from Salle s where s.adresseSalle like'%"+MC+"%'");
		Log.info("Nombre de salles dans la liste : "+req.getResultList().size());
		return req.getResultList();
	}

}
