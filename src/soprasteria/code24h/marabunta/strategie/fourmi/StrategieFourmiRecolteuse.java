package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.Arrays;

import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.FourmilieresVues;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;
import soprasteria.code24h.marabunta.informations.fourmi.TypePheromone;
import soprasteria.code24h.marabunta.strategie.StrategieConfig;
import utils.IntegerBitFlagManipulator;

/**
 * Stratégie de fourmi récoltant un maximum de nourriture
 */
public class StrategieFourmiRecolteuse implements StrategieFourmi {
	// bit 1 : 0 chercher, 1 suivre piste
	public static final int SUIVRE_PISTE = 1;
	// bit 2 : 0 vers nourriture, 1 vers fourmiliere
	public static final int RENTRER = 2;
	
	private final ActionsFourmis actionsFourmi;
	private final StrategieFourmi stratRemontePiste;
	private StrategieFourmiSuivrePiste stratSuivrePiste;
	
	public StrategieFourmiRecolteuse(ActionsFourmis actionsFourmis) {
		this.actionsFourmi = actionsFourmis;
		this.stratRemontePiste = new StrategieFourmiRemonterPiste(Arrays.asList(TypePheromone.NOTHING));
		this.stratSuivrePiste = new StrategieFourmiSuivrePiste(Arrays.asList(TypePheromone.NOURRITURE_TROUVE));
	}
	
	public StrategieFourmiRecolteuse() {
		this(new ActionsFourmis());
	}
	
	@Override
	public void cogite(Fourmi fourmi) {
		Integer[] memoires = fourmi.getMemoire();
		if(IntegerBitFlagManipulator.checkFlag(memoires[0], RENTRER)) {
			FourmilieresVues fourmiliereVue = fourmi.getFourmiliereAmie();
			if(fourmiliereVue != null) {
				this.actionsFourmi.MoveTo(fourmiliereVue.id);
			} else if(IntegerBitFlagManipulator.checkFlag(memoires[0], SUIVRE_PISTE)) {
				stratRemontePiste.cogite(fourmi);
			}
		} else {
			Nourriture nourriture = fourmi.nourritureLaPlusProche();
			if(nourriture != null) {
				if(StrategieConfig.NEAR.equals(nourriture.getZone())) {
					actionsFourmi.Collect(nourriture.getId(), 1000);
				} else {
			// TODO si nourriture présente recolter ou diriger vers
				}
			}
			// Sinon si suivre piste -> suivre la piste courante 
			// Sinon chercher piste
		}
	}

	/**
	 * @return the actionsFourmi
	 */
	public ActionsFourmis getActionsFourmi() {
		return actionsFourmi;
	}

}
