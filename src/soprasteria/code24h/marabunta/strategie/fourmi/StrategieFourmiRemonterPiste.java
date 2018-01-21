package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.List;

import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.Pheromone;

/**
 * Strategie faisant remonter une piste de phéromone de types particuliers à une fourmi pour qu'elle revienne sur ces pas.
 */
public class StrategieFourmiRemonterPiste implements StrategieFourmi {
	private final List<Integer> typesPheromone;
	private final ActionsFourmis actionsFourmi;
	
	/**
	 *  Crée une strategie faisant remonter une piste de phéromones.
	 * @param typesPhero les types de phéromone dans l'ordre de priorité
	 */
	public StrategieFourmiRemonterPiste(ActionsFourmis actionsFourmi, List<Integer> typesPhero) {
		typesPheromone = typesPhero;
		this.actionsFourmi = actionsFourmi;
	}
	
	@Override
	public boolean cogite(Fourmi fourmi) {
		for(Integer typePhero : typesPheromone) {
			Pheromone phero = fourmi.pheromoneLaMoinsPuissante(typePhero);
			if(phero != null) {
				actionsFourmi.MoveTo(phero.getId());
				return true;
			}
		}
		return false;
	}

}
