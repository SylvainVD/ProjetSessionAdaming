package com.Adaming.myapp.dao;

import java.util.List;

import com.Adaming.myapp.entities.Module;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Interface : InterfModuleDao
 * package : com.Adaming.myapp.dao ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public interface InterfModuleDao {
	public Module addModule(Module m);
	public Module modifyModule(Long idModule);
	public Module deleteModule(Long idModule);
	public Module getModule(Long idModule);
	public List<Module> getListModule();
	public List<Module> getListModulebyMC(String MC);
}
