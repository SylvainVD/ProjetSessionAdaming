package com.Adaming.myapp.metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.Adaming.myapp.dao.InterfMaterielDao;
import com.Adaming.myapp.entities.Materiel;

/*
 * Auteur : Sylvain VROLAND
 * Date : 26/05/2016
 * interface : ImplMaterielMetier ;
 * package : com.Adaming.myapp.metier ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Imterface implémentée : InterfMaterielMetier ;
 * Class concernée : Materiel
 * */
 
@Transactional
public class ImplMaterielMetier implements InterfMaterielMetier{
	
	private final Logger log = Logger.getLogger("Implémentation Materiel Métier !!!");
	private InterfMaterielDao dao;
	
	public void setDao(InterfMaterielDao dao) {
		this.dao = dao;
		log.info("Dao Materiel injecté dans le Métier !!!");
	}

	@Override
	public Materiel addMateriel(Materiel ma) {
		return dao.addMateriel(ma);
	}

	@Override
	public Materiel getMaterielById(Long id) {
		return dao.getMaterielById(id);
	}

	@Override
	public List<Materiel> getAllMateriel() {
		return dao.getAllMateriel();
	}

	@Override
	public Materiel deleteMateriel(Long id) {
		return dao.deleteMateriel(id);
	}

	@Override
	public Materiel updateMateriel(Materiel ma) {
		return dao.updateMateriel(ma);
	}

}
