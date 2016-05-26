package com.Adaming.myapp.metier;

import java.util.List;

import com.Adaming.myapp.entities.Module;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Interface : InterfModuleMetier
 * package : com.Adaming.myapp.Metier ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public interface InterfModuleMetier {
	public Module addModule(Module m);
	public Module modifyModule(Long idModule);
	public Module deleteModule(Long idModule);
	public Module getModule(Long idModule);
	public List<Module> getListModule();
	public List<Module> getListModulebyMC(String MC);
}
