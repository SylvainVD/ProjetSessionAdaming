package com.Adaming.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.Adaming.myapp.entities.Module;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : ImplModuleDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public class ImplModuleDao implements InterfModuleDao{
	@PersistenceContext
	private EntityManager em;
	private static Logger Log = Logger.getLogger("DAO Module");
	
	@Override
	public Module addModule(Module m) {
		Log.info("Debut add Module : id"+m.getIdModule());
		em.persist(m);
		Log.info("Fin add module : descr : "+m.getDescriptionModule());
		return m;
	}

	@Override
	public Module modifyModule(Module m) {
		Log.info("Debut modify module : id : "+m.getIdModule());
		em.merge(m);
		Log.info("Fin modify module : id : "+m);
		return m;
	}

	@Override
	public Module deleteModule(Long idModule) {
		Log.info("Debut delete module d'id : "+idModule);
		Module m = em.find(Module.class, idModule);
		em.remove(m);
		Log.info("Fin delete module d'id : "+m);
		return m;
	}

	@Override
	public Module getModule(Long idModule) {
		Log.info("Debut getModule module d'id : "+idModule);
		Module m = em.find(Module.class, idModule);
		Log.info("Fin getModule "+m);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getListModule() {
		Log.info("Debut getListModule");
		Query req = em.createQuery("Select m from Module m");
		Log.info("Fin getListModule avec "+req.getResultList().size()+" élément(s)");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getListModulebyMC(String MC) {
		Log.info("Debut getListModulebyMC : mot clé = "+MC);
		Query req = em.createQuery("Select m from Module m where m.nomModule like '%"+MC+"%'");
		Log.info("Fin getListModule avec "+req.getResultList().size()+" élément(s)");
		return req.getResultList();
	}

}
