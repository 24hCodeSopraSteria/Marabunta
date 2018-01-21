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
	
	@Test
	public void testPheromoneLaPlusProche() {
		Fourmi f = new Fourmi();
		List<Pheromone> pheros = new ArrayList<>();
		Pheromone expected = new Pheromone();
		expected.setDist(2);
		Pheromone other = new Pheromone();
		other.setDist(4);
		pheros.add(other);
		pheros.add(expected);
		other = new Pheromone();
		other.setDist(3);
		pheros.add(other);
		
		f.setPheromonesAProximite(pheros);
		assertTrue(expected == f.pheromoneLaPlusProche());
	}
	
	@Test
	public void testPheromoneLaPlusProcheOnePheromone() {
		Fourmi f = new Fourmi();
		List<Pheromone> pheros = new ArrayList<>();
		Pheromone expected = new Pheromone();
		expected.setDist(2);
		pheros.add(expected);
		
		f.setPheromonesAProximite(pheros);
		assertTrue(expected == f.pheromoneLaPlusProche());
	}
	
	@Test
	public void testPheromoneLaPlusProcheNoPheromone() {
		Fourmi f = new Fourmi();
		assertNull(f.pheromoneLaPlusProche());
	}
	
	@Test
	public void testPheromoneLaMoinsPuissante() {
		Fourmi f = new Fourmi();
		List<Pheromone> pheros = new ArrayList<>();
		Pheromone expected = new Pheromone();
		expected.setType(TypePheromone.NOURRITURE_TROUVE);
		expected.setPersistance(1);
		Pheromone other = new Pheromone();
		other.setPersistance(4);
		other.setType(TypePheromone.NOURRITURE_TROUVE);
		pheros.add(other);
		pheros.add(expected);
		other = new Pheromone();
		other.setType(TypePheromone.NOURRITURE_TERMINE);
		other.setPersistance(0);
		pheros.add(other);
		f.setPheromonesAProximite(pheros);
		
		assertTrue(expected == f.pheromoneLaMoinsPuissante(TypePheromone.NOURRITURE_TROUVE));
	}
	
	@Test
	public void testPheromoneLaMoinsPuissanteNoPheromone() {
		Fourmi f = new Fourmi();
		assertNull(f.pheromoneLaMoinsPuissante(TypePheromone.NOURRITURE_TERMINE));
	}
	
	@Test
	public void testPheromoneLaMoinsPuissanteNoPheromoneType() {
		Fourmi f = new Fourmi();
		List<Pheromone> pheros = new ArrayList<>();
		Pheromone expected = new Pheromone();
		expected.setType(TypePheromone.NOURRITURE_TERMINE);
		expected.setPersistance(1);
		Pheromone other = new Pheromone();
		other.setPersistance(4);
		other.setType(TypePheromone.NOTHING);
		pheros.add(other);
		pheros.add(expected);
		other = new Pheromone();
		other.setType(TypePheromone.NOURRITURE_TERMINE);
		other.setPersistance(0);
		pheros.add(other);
		f.setPheromonesAProximite(pheros);
		
		assertNull(f.pheromoneLaMoinsPuissante(TypePheromone.NOURRITURE_TROUVE));
	}
}
