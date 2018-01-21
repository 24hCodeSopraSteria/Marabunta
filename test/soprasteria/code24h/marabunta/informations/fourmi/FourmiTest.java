package soprasteria.code24h.marabunta.informations.fourmi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FourmiTest {

	@Test
	public void testNourritureLaPlusProche() {
		Fourmi f = new Fourmi();
		Nourriture n1 = new Nourriture();
		n1.setDist(10);
		Nourriture n2 = new Nourriture();
		n2.setDist(20);
		Nourriture n3 = new Nourriture();
		n3.setDist(30);

		f.getNourritureAProximite().add(n1);
		f.getNourritureAProximite().add(n2);
		f.getNourritureAProximite().add(n3);
		
		assertEquals(n1, f.nourritureLaPlusProche());
	}
	
	@Test
	public void testNourritureLaPlusProche2() {
		Fourmi f = new Fourmi();
		Nourriture n1 = new Nourriture();
		n1.setDist(300);
		Nourriture n2 = new Nourriture();
		n2.setDist(150);
		Nourriture n3 = new Nourriture();
		n3.setDist(600);

		f.getNourritureAProximite().add(n1);
		f.getNourritureAProximite().add(n2);
		f.getNourritureAProximite().add(n3);
		
		assertEquals(n2, f.nourritureLaPlusProche());
	}

	@Test
	public void testGetFourmiliereAmie() {
		Fourmi f = new Fourmi();
		List<FourmilieresVues> fourmilliereVoisines = new ArrayList<FourmilieresVues>();
		FourmilieresVues vueExpected = new FourmilieresVues();
		vueExpected.setDist(10);
		vueExpected.setFriend(true);
		FourmilieresVues vueAutre = new FourmilieresVues();
		vueAutre.setDist(100);
		fourmilliereVoisines.add(vueAutre);
		vueAutre = new FourmilieresVues();
		vueAutre.setDist(20);
		vueAutre.setFriend(true);
		fourmilliereVoisines.add(vueAutre);
		fourmilliereVoisines.add(vueExpected);
		f.setFourmilliereVoisines(fourmilliereVoisines);
		
		assertTrue(vueExpected == f.getFourmiliereAmie());
	}
	
	@Test
	public void testGetFourmiliereAmieOneFourmiliere() {
		Fourmi f = new Fourmi();
		List<FourmilieresVues> fourmilliereVoisines = new ArrayList<FourmilieresVues>();
		FourmilieresVues vueExpected = new FourmilieresVues();
		vueExpected.setDist(10);
		vueExpected.setFriend(true);
		fourmilliereVoisines.add(vueExpected);
		f.setFourmilliereVoisines(fourmilliereVoisines);
		
		assertTrue(vueExpected == f.getFourmiliereAmie());
	}
	
	@Test
	public void testGetFourmiliereAmieNoFourmiliere() {
		Fourmi f = new Fourmi();
		List<FourmilieresVues> fourmilliereVoisines = new ArrayList<FourmilieresVues>();
		f.setFourmilliereVoisines(fourmilliereVoisines);
		
		assertNull(f.getFourmiliereAmie());
	}
	
	@Test
	public void testGetFourmiliereAmieNoAmie() {
		Fourmi f = new Fourmi();
		List<FourmilieresVues> fourmilliereVoisines = new ArrayList<FourmilieresVues>();
		FourmilieresVues vueAutre = new FourmilieresVues();
		vueAutre.setDist(100);
		fourmilliereVoisines.add(vueAutre);
		vueAutre = new FourmilieresVues();
		vueAutre.setDist(20);
		fourmilliereVoisines.add(vueAutre);
		vueAutre = new FourmilieresVues();
		vueAutre.setDist(30);
		fourmilliereVoisines.add(vueAutre);
		f.setFourmilliereVoisines(fourmilliereVoisines);
		
		assertNull(f.getFourmiliereAmie());
	}
}
