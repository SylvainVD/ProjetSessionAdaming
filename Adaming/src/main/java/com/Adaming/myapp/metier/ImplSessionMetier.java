package com.Adaming.myapp.metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.Adaming.myapp.dao.InterfSessionDao;
import com.Adaming.myapp.entities.Session;

/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : ImplSessionMetier
 * package : com.Adaming.myapp.Metier ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
@Transactional
public class ImplSessionMetier implements InterfSessionMetier{
	private static Logger Log = Logger.getLogger("Session Metier");
	private InterfSessionDao sessionDao;


	public void setSessionDao(InterfSessionDao sessionDao) {
		this.sessionDao = sessionDao;
		Log.info("Session DAO injected");
	}

	@Override
	public Session addSession(Session s, Long idSalle) {
		return sessionDao.addSession(s, idSalle);
	}

	@Override
	public Session modifySession(Long idSession) {
		return sessionDao.modifySession(idSession);
	}

	@Override
	public Session deleteSession(Long idSession) {
		return sessionDao.deleteSession(idSession);
	}

	@Override
	public Session getSession(Long idSession) {
		return sessionDao.getSession(idSession);
	}

	@Override
	public List<Session> getListSession() {
		return sessionDao.getListSession();
	}

	@Override
	public List<Session> getListSessionbyMC(String MC) {
		return sessionDao.getListSessionbyMC(MC);
	}

	@Override
	public Session addModuleToSession(Long idModule, Long idSession) {
		return sessionDao.addModuleToSession(idModule, idSession);
	}

}
