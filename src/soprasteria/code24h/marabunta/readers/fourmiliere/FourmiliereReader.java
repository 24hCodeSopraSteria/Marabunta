package soprasteria.code24h.marabunta.readers.fourmiliere;

import java.math.BigInteger;

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
		String[] splitCmd = cmd.split(" ");
		
		switch(splitCmd[0]) {
			case "STOCK" :
				fourmiliere.setStock(new BigInteger(splitCmd[1]));
				break;
			case "MEMORY" :
				for(int i = 1; i < splitCmd.length; i++) {
					fourmiliere.getMemories()[i -1] = Short.parseShort(splitCmd[i]);
				}
				break;
			case "ANT_COUNT" :
				break;
			case "ANT_IN" :
				break;
			default :
				// TODO log
				break;
		}
	}

	@Override
	public Fourmiliere createInstanceT() {
		return new Fourmiliere();
	}
}
