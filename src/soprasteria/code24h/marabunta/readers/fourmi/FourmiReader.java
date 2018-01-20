package soprasteria.code24h.marabunta.readers.fourmi;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.FourmilieresVues;
import soprasteria.code24h.marabunta.informations.fourmi.FourmisVues;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;
import soprasteria.code24h.marabunta.informations.fourmi.Pheromone;
import soprasteria.code24h.marabunta.readers.MarabuntaReader;

public class FourmiReader extends MarabuntaReader<Fourmi>{

	public FourmiReader() {
		super("BEGIN ANT");
	}

	@Override
	public void parseTo(String cmd, Fourmi info) {
		String[] cmdEspace = cmd.split("\\s+");
		
		switch(cmdEspace[0]) {
			case "TYPE":
				info.setType(Integer.parseInt(cmdEspace[1]));
				break;
				
			case "MEMORY":
				info.setMemoire(new Integer[] { Integer.parseInt(cmdEspace[1]), Integer.parseInt(cmdEspace[2]) });
				break;
				
			case "ATTACKED":
				info.setAttaquee(true);
				break; 
				
			case "STAMINA":
				info.setStamina(Integer.parseInt(cmdEspace[1]));
				break;
				
			case "STOCK":
				info.setStock(Integer.parseInt(cmdEspace[1]));
				break;
				
			case "SEE_PHEROMONE":
				Pheromone ph = new Pheromone();
				ph.setId(Integer.parseInt(cmdEspace[1]));
				ph.setZone(cmdEspace[2]);
				ph.setDist(Integer.parseInt(cmdEspace[3]));
				ph.setType(Integer.parseInt(cmdEspace[4]));
				ph.setPersistance(Integer.parseInt(cmdEspace[5]));
				
				info.getPheromonesAProximite().add(ph);
				break;
				
			case "SEE_ANT": 
				FourmisVues fv = new FourmisVues();
				fv.setId(Integer.parseInt(cmdEspace[1]));
				fv.setZone(cmdEspace[2]);
				fv.setDist(Integer.parseInt(cmdEspace[3]));
				fv.setFriend(cmdEspace[4].equals("FRIEND"));
				fv.setStamina(Integer.parseInt(cmdEspace[5]));
				
				info.fourmisAProximite.add(fv);
				break;
				
			case "SEE_NEST":
				FourmilieresVues fmv = new FourmilieresVues();
				fmv.setId(Integer.parseInt(cmdEspace[2]));
				fmv.setZone(Integer.parseInt(cmdEspace[3]));
				fmv.setDist(Integer.parseInt(cmdEspace[4]));
				fmv.setFriend(cmdEspace[5].equals("FRIEND"));
				
				info.getFourmilliereVoisines().add(fmv);
				
				break;
				
			case "SEE_FOOD":
				Nourriture nr = new Nourriture();
				nr.setId(Integer.parseInt(cmdEspace[2]));
				nr.setZone(cmdEspace[3]);
				nr.setDist(Integer.parseInt(cmdEspace[4]));
				nr.setAmount(Integer.parseInt(cmdEspace[5]));
				
				info.getNourritureAProximite().add(nr);
				
				break;
			default:
				break;
				
		}
	}

	@Override
	public Fourmi createInstanceT() {
		return new Fourmi();
	}

}
