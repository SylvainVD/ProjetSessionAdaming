package com.Adaming.myapp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Adaming.myapp.entities.Module;
import com.Adaming.myapp.metier.InterfModuleMetier;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : TestModuleMetier (JUNIT)
 * package : com.Adaming.myapp ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public class TestModuleMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfModuleMetier moduleMetier;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		moduleMetier = (InterfModuleMetier) context.getBean("moduleMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddModule() {
		Module m = new Module("Spring", 3, "Framework Spring");
		moduleMetier.addModule(m);
		Module m2 = new Module("Webservice", 5, "Apprendre à créer, tester et consommer des webservices");
		moduleMetier.addModule(m2);
		assertNotNull(m.getIdModule());
	}

	@Test
	public void testModifyModule() {
		Module m = moduleMetier.getModule(2L);
		m.setDureeModule(12);
		moduleMetier.modifyModule(m);
		assertTrue(m.getDureeModule()==12);
	}

	@Test
	public void testDeleteModule() {
		List<Module> tab1 = moduleMetier.getListModule();
		moduleMetier.deleteModule(4L);
		List<Module> tab2 = moduleMetier.getListModule();
		assertTrue(tab1.size()==tab2.size()+1);
	}

	@Test
	public void testGetModule() {
		Module m = moduleMetier.getModule(5L);
		assertEquals(m.getDureeModule(),1);
	}

	@Test
	public void testGetListModule() {
		List<Module> tab = moduleMetier.getListModule();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListModulebyMC() {
		List<Module> tab = moduleMetier.getListModulebyMC("A");
		assertTrue(tab.size()>0);
	}

}
