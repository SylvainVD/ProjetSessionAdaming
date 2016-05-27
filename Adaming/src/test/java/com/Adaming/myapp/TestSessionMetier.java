package com.Adaming.myapp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Adaming.myapp.entities.Session;
import com.Adaming.myapp.metier.InterfSessionMetier;
/*
 * Auteur : Arnaud MARY
 * Date : 26/05/2016
 * Class : TestSessionMetier (JUNIT)
 * package : com.Adaming.myapp ;
 * Version : 1.0 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * */
public class TestSessionMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfSessionMetier sessionMetier;
	private SimpleDateFormat SF = new SimpleDateFormat("yyyy/MM/dd");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		sessionMetier = (InterfSessionMetier) context.getBean("sessionMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddSession() {
		try {
			Session s = new Session(SF.parse("2013/12/01"), SF.parse("2013/02/28"), "Session hiver 2013");
			Session s1 = new Session(SF.parse("2013/06/01"), SF.parse("2013/08/15"), "Session Ete 2013");
			sessionMetier.addSession(s, 5L);
			sessionMetier.addSession(s1, 4L);
			assertNotNull(s.getIdSession());
			assertNotNull(s1.getIdSession());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testModifySession() {
		Session s = sessionMetier.getSession(3L);
		s.setNomSession("Test");
		sessionMetier.modifySession(4L);
		assertTrue(s.getNomSession()=="Test");
	}

	@Test
	public void testDeleteSession() {
		List<Session> tab1 = sessionMetier.getListSession();
		sessionMetier.deleteSession(9L);
		List<Session> tab2 = sessionMetier.getListSession();
		assertEquals(tab1.size(),tab2.size()+1);
	}

	@Test
	public void testGetSession() {
		Session s = sessionMetier.getSession(1L);
		assertEquals(s.getNomSession(),"Session des boss");
	}

	@Test
	public void testGetListSession() {
		List<Session> tab = sessionMetier.getListSession();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListSessionbyMC() {
		List<Session> tab = sessionMetier.getListSessionbyMC("Session");
		assertTrue(tab.size()>0);
	}

	@Test
	public void testAddModuleToSession() {
		sessionMetier.addModuleToSession(4L, 1L);
		Session s = sessionMetier.getSession(1L);
		assertEquals(s.getListeModuleDeLaSession().get(1).getNomModule(), "Java");
	}

}
