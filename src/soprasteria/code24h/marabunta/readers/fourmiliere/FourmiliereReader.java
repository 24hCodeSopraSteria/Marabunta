package soprasteria.code24h.marabunta.readers.fourmiliere;

import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;
import soprasteria.code24h.marabunta.readers.MarabuntaReader;

/**
 * Lecteur de données de foumilière.
 */
public class FourmiliereReader extends MarabuntaReader<Fourmiliere>{

	public FourmiliereReader() {
		super("BEGIN NEST");
	}

	public void parseTo(String cmd, Fourmiliere fourmiliere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fourmiliere createInstanceT() {
		return new Fourmiliere();
	}
}
