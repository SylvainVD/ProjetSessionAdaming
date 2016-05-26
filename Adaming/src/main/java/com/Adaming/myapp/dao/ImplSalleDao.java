package com.Adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return s;
	}

	@Override
	public Salle modifySalle(Long idSalle) {
		return null;
	}

	@Override
	public Salle deleteSalle(Long idSalle) {
		return null;
	}

	@Override
	public Salle getSalle(Long idSalle) {
		return null;
	}

	@Override
	public List<Salle> getListSalle() {
		return null;
	}

}
