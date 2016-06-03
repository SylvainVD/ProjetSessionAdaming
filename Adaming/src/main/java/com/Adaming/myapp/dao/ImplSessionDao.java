package com.Adaming.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.Adaming.myapp.entities.Module;
import com.Adaming.myapp.entities.Salle;
import com.Adaming.myapp.entities.Session;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : ImplSessionDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public class ImplSessionDao implements InterfSessionDao {
	@PersistenceContext
	private EntityManager em;
	private static Logger Log = Logger.getLogger("DAO Session");

	@Override
	public Session addSession(Session s, Long idSalle) {
		Log.info("Debut addSession : "+s.getIdSession() +" nom session : "+s.getNomSession());
		Salle sa = em.find(Salle.class, idSalle);
		s.setSalleDeLaSession(sa);
		em.persist(s);
		sa.getListeSessionDeLaSalle().add(s);
		em.merge(sa);
		Log.info("Fin addSession");
		return s;
	}

	@Override
	public Session modifySession(Session s) {
		Log.info("Debut modify session id : "+s.getIdSession());
		em.merge(s);
		Log.info("Fin modify session : "+s.getNomSession());
		return s;
	}

	@Override
	public Session deleteSession(Long idSession) {
		Log.info("Debut delete session id : "+idSession);
		Session s = em.find(Session.class, idSession);
		em.remove(s);
		Log.info("Fin delete session");
		return s;
	}

	@Override
	public Session getSession(Long idSession) {
		Log.info("Debut getSession id : "+idSession);
		Session s = em.find(Session.class, idSession);
		Log.info("Fin getSession : nom "+s.getNomSession());
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getListSession() {
		Log.info("Debut GetListSession");
		Query req = em.createQuery("Select s from Session s");
		Log.info("Fin GetListSession avec "+req.getResultList().size()+" élément(s)");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getListSessionbyMC(String MC) {
		Log.info("Debut GetListSessionbyMC");
		Query req = em.createQuery("Select s from Session s where s.nomSession like '%"+MC+"%'");
		Log.info("Fin GetListSessionbyMC avec "+req.getResultList().size()+" élément(s)");
		return req.getResultList();
	}

	@Override
	public Session addModuleToSession(Long idModule, Long idSession) {
		Log.info("Debut addModuleToSession : idModule : "+idModule +" idSession : "+idSession);
		Module m = em.find(Module.class, idModule);
		Log.info("nom module a ajouter : "+m.getNomModule());
		Session s = em.find(Session.class, idSession);
		s.getListeModuleDeLaSession().add(m);
		Log.info("Fin addModuleToSession : module ajouté");
		return s;
	}

}
