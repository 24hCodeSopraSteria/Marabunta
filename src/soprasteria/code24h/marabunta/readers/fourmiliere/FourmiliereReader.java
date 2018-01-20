package soprasteria.code24h.marabunta.readers.fourmiliere;

import java.util.List;

import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

/**
 * Lecteur de données de foumilière.
 */
public class FourmiliereReader {
	public Fourmiliere read(List<String> commandes) {
        Fourmiliere fourmiliere = null;
		if(!commandes.isEmpty() && "BEGIN NEST".equalsIgnoreCase(commandes.get(0))) {
			fourmiliere = new Fourmiliere();
			for(String cmd : commandes) {
				parseTo(cmd, fourmiliere);
			}
		}
		return fourmiliere;
	}

	private void parseTo(String cmd, Fourmiliere fourmiliere) {
		// TODO Auto-generated method stub
		
	}
}
