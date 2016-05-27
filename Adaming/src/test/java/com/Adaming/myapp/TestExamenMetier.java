package com.Adaming.myapp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Adaming.myapp.entities.Examen;
import com.Adaming.myapp.metier.InterfExamenMetier;

public class TestExamenMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfExamenMetier metierExamen;
	private SimpleDateFormat SF = new SimpleDateFormat("yyyy/MM/dd");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metierExamen = (InterfExamenMetier) context.getBean("metierExamen");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddExamen() {
		try {
			Examen e = new Examen("Spring", SF.parse("2016/05/15"),11d);
			metierExamen.addExamen(e,1L);
			assertNotNull(e.getIdExamen());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetExamen() {
		Examen e = metierExamen.getExamen(1L);
		assertEquals(e.getIntituleExamen(), "Java");
	}

	@Test
	public void testGetAllExamen() {
		List<Examen> tab = metierExamen.getAllExamen();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testUpdateExamen() {
		Examen e = metierExamen.getExamen(2L);
		e.setIntituleExamen("Test");
		metierExamen.updateExamen(e);
		assertEquals(e.getIntituleExamen(),"Test");
	}

	@Test
	public void testDeleteExamen() {
		List<Examen> tab1 = metierExamen.getAllExamen();
		metierExamen.deleteExamen(3L);
		List<Examen> tab2 = metierExamen.getAllExamen();
		assertEquals(tab1.size(), tab2.size()+1);
	}

	/*@Test
	public void testAddExamenToEtudiant() {
		metierExamen.addExamenToEtudiant(2L, 1L);
		Etudiant e = metierEtudiant.getEtudiantById(1L);
		assertEquals(e.getListeExamenDeLEtudiant().get(1).getIntituleExamen(), "RIA");
	}*/

}
