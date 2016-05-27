package com.Adaming.myapp.metier;

import java.util.List;

import com.Adaming.myapp.entities.Materiel;

public interface InterfMaterielMetier {

	public Materiel addMateriel(Materiel ma);

	public Materiel getMaterielById(Long id);

	public List<Materiel> getAllMateriel();

	public Materiel deleteMateriel(Long id);

	public Materiel updateMateriel(Materiel ma);
 
}
