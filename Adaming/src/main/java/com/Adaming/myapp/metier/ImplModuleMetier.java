package com.Adaming.myapp.metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.Adaming.myapp.dao.InterfModuleDao;
import com.Adaming.myapp.entities.Module;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : ImplModuleMetier
 * package : com.Adaming.myapp.Metier ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
@Transactional
public class ImplModuleMetier implements InterfModuleMetier{
	private static Logger Log = Logger.getLogger("Metier Module");
	private InterfModuleDao moduleDao;
	
	public void setModuleDao(InterfModuleDao moduleDao) {
		this.moduleDao = moduleDao;
		Log.info("Dao Module Injected");
	}

	@Override
	public Module addModule(Module m) {
		return moduleDao.addModule(m);
	}

	@Override
	public Module modifyModule(Module mod) {
		return moduleDao.modifyModule(mod);
	}

	@Override
	public Module deleteModule(Long idModule) {
		return moduleDao.deleteModule(idModule);
	}

	@Override
	public Module getModule(Long idModule) {
		return moduleDao.getModule(idModule);
	}

	@Override
	public List<Module> getListModule() {
		return moduleDao.getListModule();
	}

	@Override
	public List<Module> getListModulebyMC(String MC) {
		return moduleDao.getListModulebyMC(MC);
	}
	

}
