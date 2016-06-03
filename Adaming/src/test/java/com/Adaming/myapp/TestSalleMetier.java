package com.Adaming.myapp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Adaming.myapp.entities.Salle;
import com.Adaming.myapp.metier.InterfSalleMetier;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : TestSalleMetier (JUNIT)
 * package : com.Adaming.myapp ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public class TestSalleMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfSalleMetier salleMetier;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		salleMetier = (InterfSalleMetier) context.getBean("salleMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddSalle() {
		Salle s = new Salle("Toulouse", 158, 20);
		salleMetier.addSalle(s);
		Salle s2 = new Salle("Nantes", 99, 666);
		salleMetier.addSalle(s2);
		assertNotNull(s.getIdSalle());
		assertNotNull(s2.getIdSalle());
	}

	@Test
	public void testModifySalle() {
		Salle s = salleMetier.getSalle(1L);
		s.setNumSalle(2000);
		salleMetier.modifySalle(s);
		assertEquals(s.getNumSalle(), 2000);
	}

	@Test
	public void testDeleteSalle() {
		List<Salle> tab1 = salleMetier.getListSalle();
		salleMetier.deleteSalle(3L);
		List<Salle> tab2 = salleMetier.getListSalle();
		assertEquals(tab1.size(), tab2.size()+1);
	}

	@Test
	public void testGetSalle() {
		Salle s = salleMetier.getSalle(2L);
		assertEquals(s.getAdresseSalle(), "Lille");
	}

	@Test
	public void testGetListSalle() {
		List<Salle> tab = salleMetier.getListSalle();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListSallebyMC() {
		List<Salle> tab = salleMetier.getListSallebyMC("Paris");
		assertTrue(tab.size()>0);
	}

}
