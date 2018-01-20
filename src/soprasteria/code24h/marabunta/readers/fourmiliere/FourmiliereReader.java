package soprasteria.code24h.marabunta.readers.fourmiliere;

import java.math.BigInteger;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
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
					fourmiliere.getMemories()[i -1] = Integer.parseInt(splitCmd[i]);
				}
				break;
			case "ANT_COUNT" :
				fourmiliere.setNbFourmis(Integer.parseInt(splitCmd[2]));
				break;
			case "ANT_IN" :
				Fourmi f = new Fourmi();
				f.setType(Integer.parseInt(splitCmd[1]));
				f.getMemoire()[0] = Integer.parseInt(splitCmd[1]);
				f.getMemoire()[1] = Integer.parseInt(splitCmd[2]);
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
