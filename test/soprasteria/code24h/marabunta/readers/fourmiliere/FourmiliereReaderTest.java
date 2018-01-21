package soprasteria.code24h.marabunta.readers.fourmiliere;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

public class FourmiliereReaderTest {
	FourmiliereReader reader = new FourmiliereReader();
	
	@Test
	public void testRead() {
		List<String> commandes = new ArrayList<>();
		commandes.add("BEGIN NEST");
		commandes.add("STOCK 4000000");
		commandes.add("MEMORY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
		commandes.add("ANT_COUNT 0 3");
		commandes.add("ANT_COUNT 1 15");
		commandes.add("ANT_IN 0 1 2");
		commandes.add("ANT_IN 0 1 3");
		commandes.add("ANT_IN 0 2 4");
		commandes.add("ANT_IN 0 3 2");
		commandes.add("END");
		Fourmiliere fourmiliere = reader.read(commandes);
		
		assertEquals(4, fourmiliere.getFourmiIn().size());
		assertEquals(new BigInteger("4000000"), fourmiliere.getStock());
		assertEquals(Integer.valueOf(3), fourmiliere.getNbFourmisParType(0));
		assertEquals(Integer.valueOf(15), fourmiliere.getNbFourmisParType(1));
		assertEquals(Integer.valueOf(18), fourmiliere.getNbFourmis());
	}

}
