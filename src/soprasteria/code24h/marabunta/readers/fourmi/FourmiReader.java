package soprasteria.code24h.marabunta.readers.fourmi;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
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
			case "STAMINA":
				info.setStamina(Integer.parseInt(cmdEspace[1]));
				break;
			case "STOCK":
				info.setStock(Integer.parseInt(cmdEspace[1]));
				break;
			case "SEE_PHEROMONE":
				break;
			case "SEE_ANT": 
				break;
			case "SEE_NEST":
				break;
			case "SEE_FOOD":
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
