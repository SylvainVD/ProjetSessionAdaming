package com.Adaming.myapp.metier;

import java.util.List;

import com.Adaming.myapp.entities.Module;
import com.Adaming.myapp.entities.Session;

/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Interface : InterfSessionMetier
 * package : com.Adaming.myapp.Metier ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public interface InterfSessionMetier {
	public Session addSession(Session s, Long idSalle);
	public Session modifySession(Session s);
	public Session deleteSession(Long idSession);
	public Session getSession(Long idSession);
	public List<Session> getListSession();
	public List<Session> getListSessionbyMC(String MC);
	public Session addModuleToSession(Long idModule, Long idSession);
	public List<Module> getListModuleSession(Long idSession);
}
