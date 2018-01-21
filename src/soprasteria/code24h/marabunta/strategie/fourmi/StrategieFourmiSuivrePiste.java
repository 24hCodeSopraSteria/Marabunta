package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.List;

import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;

/**
 * Strategie faisant suivre une piste de phéromone de types particuliers à une fourmie pour qu'elle revienne sur ces pas.
 */
public class StrategieFourmiSuivrePiste implements StrategieFourmi {
	private final List<Integer> typesPheromone;
	private final ActionsFourmis actionsFourmi;
	
	/**
	 * Crée une strategie faisant suivre une piste de phéromone.
	 * @param typesPhero les types de phéromones à suivre dans l'ordre de priorité
	 */
	public StrategieFourmiSuivrePiste(ActionsFourmis actionsFourmi, List<Integer> typesPhero) {
		typesPheromone = typesPhero;
		this.actionsFourmi = actionsFourmi;
	}
	
	@Override
	public boolean cogite(Fourmi elem) {
		// TODO chercher phéromonone la plus forte puis suivre
		return false;
	}

}
