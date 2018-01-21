package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.List;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;

/**
 * Strategie faisant suivre une piste de phéromone de types particuliers à une fourmie pour qu'elle revienne sur ces pas.
 */
public class StrategieFourmiSuivrePiste implements StrategieFourmi {
	public final List<Integer> typesPheromone;
	
	/**
	 * Crée une strategie faisant suivre une piste de phéromone.
	 * @param typesPhero les types de phéromones à suivre dans l'ordre de priorité
	 */
	public StrategieFourmiSuivrePiste(List<Integer> typesPhero) {
		typesPheromone = typesPhero;
	}
	
	@Override
	public void cogite(Fourmi elem) {
		// TODO chercher phéromonone la plus forte puis suivre

	}

}
