package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.Arrays;

import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.FourmilieresVues;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;
import soprasteria.code24h.marabunta.informations.fourmi.Pheromone;
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
	private StrategieFourmi stratSurvie;
	
	public StrategieFourmiRecolteuse(ActionsFourmis actionsFourmis) {
		this.actionsFourmi = actionsFourmis;
		this.stratRemontePiste = new StrategieFourmiRemonterPiste(actionsFourmis, Arrays.asList(TypePheromone.NOTHING));
		this.stratSuivrePiste = new StrategieFourmiSuivrePiste(actionsFourmis, Arrays.asList(TypePheromone.NOURRITURE_TROUVE));
		this.stratSurvie = new StrategieFourmiStaminaSurvi(actionsFourmis);
	}
	
	public StrategieFourmiRecolteuse() {
		this(new ActionsFourmis());
	}
	
	@Override
	public boolean cogite(Fourmi fourmi) {
		if(stratSurvie.cogite(fourmi)) {
			// On a manger pour sauver la nourriture
			return true;
		}
		Integer[] memoires = fourmi.getMemoire();
		if(IntegerBitFlagManipulator.checkFlag(memoires[0], RENTRER)) {
			FourmilieresVues fourmiliereVue = fourmi.getFourmiliereAmie();
			if(fourmiliereVue != null) {
				this.actionsFourmi.MoveTo(fourmiliereVue.id);
			} else if(IntegerBitFlagManipulator.checkFlag(memoires[0], SUIVRE_PISTE)) {
				if(!stratRemontePiste.cogite(fourmi)) {
					this.actionsFourmi.Explore();
				}
			} else {
				actionsFourmi.Explore();
			}
		} else {
			Nourriture nourriture = fourmi.nourritureLaPlusProche();
			if(nourriture != null) {
				if(StrategieConfig.NEAR.equals(nourriture.getZone())) {
					if(fourmi.getStock() +	nourriture.getAmount() >= 1000) {
						// Activer les flags pour rentrer à la maison
						actionsFourmi.SetMemory(memoires[0] | RENTRER | SUIVRE_PISTE, memoires[1]);
					} else {
						// désactiver suivre piste
						actionsFourmi.SetMemory(memoires[0] & ~SUIVRE_PISTE, memoires[1]);
					}
					actionsFourmi.Collect(nourriture.getId(), 1000);
				} else {
					actionsFourmi.MoveTo(nourriture.getId());
				}
			} else if(IntegerBitFlagManipulator.checkFlag(memoires[0], SUIVRE_PISTE)) {
				if(!stratSuivrePiste.cogite(fourmi)) {
					actionsFourmi.Explore();
				}
			} else {
				// Sinon chercher piste
				Pheromone phero = fourmi.pheromoneLaMoinsPuissante(TypePheromone.NOURRITURE_TROUVE);
				if(phero != null) {
					actionsFourmi.MoveTo(phero.getId());
				} else {
					actionsFourmi.Explore();
				}
			}
		}
		return true;
	}

	/**
	 * @return the actionsFourmi
	 */
	public ActionsFourmis getActionsFourmi() {
		return actionsFourmi;
	}

}
