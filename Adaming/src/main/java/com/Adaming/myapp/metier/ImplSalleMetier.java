package com.Adaming.myapp.metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.Adaming.myapp.dao.InterfSalleDao;
import com.Adaming.myapp.entities.Salle;

/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : ImplSalleMetier
 * package : com.Adaming.myapp.Metier ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
@Transactional
public class ImplSalleMetier implements InterfSalleMetier {
	private static Logger Log = Logger.getLogger("Salle Metier");
	private InterfSalleDao salleDao;

	public void setSalleDao(InterfSalleDao salleDao) {
		this.salleDao = salleDao;
		Log.info("Salle DAO injected");
	}

	@Override
	public Salle addSalle(Salle s) {
		return salleDao.addSalle(s);
	}

	@Override
	public Salle modifySalle(Salle s) {
		return salleDao.modifySalle(s);
	}

	@Override
	public Salle deleteSalle(Long idSalle) {
		return salleDao.deleteSalle(idSalle);
	}

	@Override
	public Salle getSalle(Long idSalle) {
		return salleDao.getSalle(idSalle);
	}

	@Override
	public List<Salle> getListSalle() {
		return salleDao.getListSalle();
	}

	@Override
	public List<Salle> getListSallebyMC(String MC) {
		return salleDao.getListSallebyMC(MC);
	}

}
