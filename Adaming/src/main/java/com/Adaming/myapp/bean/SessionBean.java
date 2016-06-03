package com.Adaming.myapp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.Adaming.myapp.entities.Module;
import com.Adaming.myapp.entities.Salle;
import com.Adaming.myapp.entities.Session;
import com.Adaming.myapp.metier.InterfModuleMetier;
import com.Adaming.myapp.metier.InterfSalleMetier;
import com.Adaming.myapp.metier.InterfSessionMetier;

@Controller
@Component(value = "sessionBean")
@SessionScoped
public class SessionBean {
	@Autowired
	private InterfSessionMetier sessionMetier;
	@Autowired
	private InterfSalleMetier salleMetier;
	@Autowired
	private InterfModuleMetier moduleMetier;
	private Logger Log = Logger.getLogger("Bean Session");

	private Session session = new Session();
	private Session sessionR = new Session();
	private Session sessiondel = new Session();
	private Session sessionup = new Session();
	private Session  sessionmod = new Session();
	private Long idsession;
	private Long idModule;
	private Long idsalle;
	private Date datedeb;
	private Date datefin;
	private String nomSession;
	public List<Session> tab;
	public List<Module> tabMod = new ArrayList<Module>();
	private List<Long> tabIdSalle = new ArrayList<Long>();

	// Getter and setters
	

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSessionR() {
		return sessionR;
	}

	public void setSessionR(Session sessionR) {
		this.sessionR = sessionR;
	}

	public Session getSessiondel() {
		return sessiondel;
	}

	public void setSessiondel(Session sessiondel) {
		this.sessiondel = sessiondel;
	}

	public Session getSessionup() {
		return sessionup;
	}

	public void setSessionup(Session sessionup) {
		this.sessionup = sessionup;
	}

	public Session getSessionmod() {
		return sessionmod;
	}

	public void setSessionmod(Session sessionmod) {
		this.sessionmod = sessionmod;
	}

	public Long getIdsession() {
		return idsession;
	}

	public void setIdsession(Long idsession) {
		this.idsession = idsession;
	}

	public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	public Long getIdsalle() {
		return idsalle;
	}

	public void setIdsalle(Long idsalle) {
		this.idsalle = idsalle;
	}

	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getNomSession() {
		return nomSession;
	}

	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}

	public List<Session> getTab() {
		return tab;
	}

	public void setTab(List<Session> tab) {
		this.tab = tab;
	}

	public List<Module> getTabMod() {
		return tabMod;
	}

	public void setTabMod(List<Module> tabMod) {
		this.tabMod = tabMod;
	}

	public List<Long> getTabIdSalle() {
		return tabIdSalle;
	}

	public void setTabIdSalle(List<Long> tabIdSalle) {
		this.tabIdSalle = tabIdSalle;
	}

	// Methodes
	public Session addSession(Date datedebut, Date datef, String nomSess,
			Long idsalle) {
		Log.info("Debut add session avec date deb : " + datedebut
				+ " date fin : " + datefin + " nom session : " + nomSess);
		Session s = new Session();
		s.setDateDebSession(datedebut);
		s.setDateFinSession(datef);
		s.setNomSession(nomSess);
		session = sessionMetier.addSession(s, idsalle);
		Log.info("Fin add session avec id :" + s.getIdSession());
		return session;
	}

	public List<Session> getList() {
		Log.info("Debut get liste session");
		tab = sessionMetier.getListSession();
		Log.info("Fin get liste session avec : " + tab.size() + " sessions");
		return tab;
	}
	public List<Long> getListidSalle(){
		Log.info("Debut get list id salle");
		List<Salle> tab = salleMetier.getListSalle();
		tabIdSalle.clear();
		for (Salle s : tab) {
			tabIdSalle.add(s.getIdSalle());
		}
		Log.info("Fin get list id salle avec : "+tabIdSalle.size()+" id dans la liste");
		return tabIdSalle;
	}
	public Session getSession(Long idSession){
		Log.info("Debut get Session avec id : "+idSession);
		Session s = new Session();
		s = sessionMetier.getSession(idSession);
		sessionR =s;
		Log.info("Fin get Session");
		return sessionR;
	}
	public Session deleteSession(Long idSession){
		Log.info("Debut delete session avec id : " + idSession);
		Session del = new Session();
		del = sessionMetier.deleteSession(idSession);
		sessiondel = del;
		Log.info("Fin delete module");
		return sessiondel;
	}
	public Session modifySession(Long idSession, Date ddeb, Date dfin, String nom){
		Log.info("Debut modify session avec id :"+idSession+" date deb : "+ddeb +" date fin : "+dfin +" nom : "+nom);
		Session s = sessionMetier.getSession(idSession);
		s.setDateDebSession(ddeb);
		s.setDateFinSession(dfin);
		s.setNomSession(nom);
		sessionup = sessionMetier.modifySession(s);
		Log.info("Fin modify session");
		return sessionup;
		
	}
	public List<Module> getModulesSession(Long idsession){
		Log.info("Debut get list modules de la session d'id :"+idsession);
		List<Module> tabmodule = sessionMetier.getListModuleSession(idsession);
		Log.info("Fin get list modules de la session avec : "+tabMod.size()+" modules");
		tabMod = tabmodule;
		return tabMod;
	}

}
