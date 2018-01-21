package soprasteria.code24h.marabunta.strategie.fourmi;

import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.FourmilieresVues;
import soprasteria.code24h.marabunta.strategie.StrategieConfig;

/**
 * Stratégie de survie par rapport au paramètre stamina.
 */
public class StrategieFourmiStaminaSurvi implements StrategieFourmi {
	private final ActionsFourmis actionsFourmi;
	
	public StrategieFourmiStaminaSurvi(ActionsFourmis actionsFourmi) {
		this.actionsFourmi = actionsFourmi;
	}
	
	@Override
	public boolean cogite(Fourmi fourmi) {
		if(fourmi.getStamina() < 6 && fourmi.getStock() > 10) {
			FourmilieresVues fourmiliere = fourmi.getFourmiliereAmie();
			if(StrategieConfig.NEAR.equals(fourmiliere.getZone())) {
				actionsFourmi.Eat(1);
				return true;
			}
		}
		return false;
	}

}
