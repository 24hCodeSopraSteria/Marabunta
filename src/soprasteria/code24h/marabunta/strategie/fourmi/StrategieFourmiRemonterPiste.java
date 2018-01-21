package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.List;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;

/**
 * Strategie faisant remonter une piste de phéromone de types particuliers à une fourmi pour qu'elle revienne sur ces pas.
 */
public class StrategieFourmiRemonterPiste implements StrategieFourmi {
	public final List<Integer> typesPheromone;
	
	/**
	 *  Crée une strategie faisant remonter une piste de phéromones.
	 * @param typesPhero les types de phéromone dans l'ordre de priorité
	 */
	public StrategieFourmiRemonterPiste(List<Integer> typesPhero) {
		typesPheromone = typesPhero;
	}
	
	@Override
	public void cogite(Fourmi elem) {
		// TODO chercher Pheromone la plus faible puis suivre
	}

}
