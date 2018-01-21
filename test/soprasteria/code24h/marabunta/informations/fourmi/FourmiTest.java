package soprasteria.code24h.marabunta.informations.fourmi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FourmiTest {

	@Test
	void testNourritureLaPlusProche() {
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
	void testNourritureLaPlusProche2() {
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

}
