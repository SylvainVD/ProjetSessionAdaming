package com.Adaming.myapp.bean;

import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.Adaming.myapp.entities.Module;
import com.Adaming.myapp.metier.InterfModuleMetier;

/*Auteur: Arnaud MARY
 * nom Projet: Adaming
 *date : 27/05/2016
 *Package: com.Adaming.myapp.bean
 *Class: ModuleBean
 *version:1.0
 * 
 * */

@Controller
@Component(value = "moduleBean")
@SessionScoped
public class ModuleBean {
	@Autowired
	private InterfModuleMetier moduleMetier;

	private static Logger Log = Logger.getLogger("Bean Module");
	// Attributs
	private Module module = new Module();
	private Long idModule;
	private String nomModule;
	private int dureeModule;
	private String descriptionModule;
	private List<Module> tab;
	private String motcle;
	private Module moddel;
	private Module moduleR;
	private Module moduleUp;

	// Getters and setters
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public int getDureeModule() {
		return dureeModule;
	}

	public void setDureeModule(int dureeModule) {
		this.dureeModule = dureeModule;
	}

	public String getDescriptionModule() {
		return descriptionModule;
	}

	public void setDescriptionModule(String descriptionModule) {
		this.descriptionModule = descriptionModule;
	}

	public List<Module> getTab() {
		return tab;
	}

	public void setTab(List<Module> tab) {
		this.tab = tab;
	}

	public String getMotcle() {
		return motcle;
	}

	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}

	public Module getModdel() {
		return moddel;
	}

	public void setModdel(Module moddel) {
		this.moddel = moddel;
	}

	public Module getModuleR() {
		return moduleR;
	}

	public void setModuleR(Module moduleR) {
		this.moduleR = moduleR;
	}

	public Module getModuleUp() {
		return moduleUp;
	}

	public void setModuleUp(Module moduleUp) {
		this.moduleUp = moduleUp;
	}

	// Methodes
	public Module addModule(String nomModule, int dureeModule,
			String descriptionModule) {
		Log.info("Debut ajout add Module du bean avec nomModule : " + nomModule
				+ " durée = " + dureeModule + " description : "
				+ descriptionModule);
		Module m = new Module();
		m.setNomModule(nomModule);
		m.setDureeModule(dureeModule);
		m.setDescriptionModule(descriptionModule);
		module = moduleMetier.addModule(m);
		return module;
	}

	public Module modifyModule(Long idModule, String nomMod, Integer dureeMod,
			String descrMod) {
		Log.info("Debut modification module avec : " + nomMod
				+ " avec durée : " + dureeMod + " description : " + descrMod);
		Module mod = new Module();
		mod = moduleMetier.getModule(idModule);
		if (nomMod != null) {
			mod.setNomModule(nomMod);
		}
		if (dureeMod != null) {
			mod.setDureeModule(dureeMod);
		}
		if (descrMod != null) {
			mod.setDescriptionModule(descrMod);
		}
		moduleUp = moduleMetier.modifyModule(mod);
		Log.info("Nom mod : " + moduleUp.getNomModule());
		return moduleUp;
	}

	public Module deleteModule(Long idModule) {
		Log.info("Debut delete module avec id : " + idModule);
		Module del = new Module();
		del = moduleMetier.deleteModule(idModule);
		moddel = del;
		Log.info("Fin delete module");
		return moddel;
	}

	public Module getModule(Long idModule) {
		Log.info("Debut get module avec id : " + idModule);
		Module mod = new Module();
		mod = moduleMetier.getModule(idModule);
		moduleR = mod;
		Log.info("Fin get module : " + moduleR.getNomModule());
		return moduleR;
	}

	public List<Module> getListModule() {
		Log.info("Debut get liste module");
		tab = moduleMetier.getListModule();
		Log.info("Fin get liste module avec : " + tab.size() + " modules");
		return tab;
	}

	public List<Module> getListModulebyMC(String MC) {
		Log.info("Debut get liste module par mot clé : " + MC);
		tab = moduleMetier.getListModulebyMC(MC);
		Log.info("Fin get liste module par mc avec : " + tab.size() + " modules");
		return tab;
	}

}
