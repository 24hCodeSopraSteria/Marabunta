package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.LinkedList;
import java.util.List;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;
import soprasteria.code24h.marabunta.strategie.StrategieConfig;

public class StrategieFourmiBasique implements StrategieFourmi {

	ActionsFourmis actionsFourmi = new ActionsFourmis();

	@Override
	public void cogite(Fourmi fourmi) {
		List<Nourriture> nourritures= fourmi.getNourritureAProximite();
		Integer[] memoireFourmi = fourmi.getMemoire();
		int cptCycle = memoireFourmi[0];
		if(cptCycle >= StrategieConfig.MAX_CPT) {
			actionsFourmi.SetMemory(0, memoireFourmi[1]);
			memoireFourmi[0] = 0;
		}
		if(cptCycle % StrategieConfig.CYCLE_PHEROMONE == 0) {
			actionsFourmi.PutPheromone(memoireFourmi[1]);
			return ;
		}
		if (memoireFourmi[1] == 1) {
			// Retour au bercail
			//if (fourmi.getFourmilliereVoisines());
			//actionsFourmi.
		}

		if (!nourritures.isEmpty()) {

			// Si il y a de la nourriture 
			Nourriture nourritureProche = fourmi.nourritureLaPlusProche();
			
			if (nourritureProche != null && nourritureProche.getZone() == StrategieConfig.NEAR) {
				actionsFourmi.SetMemory(memoireFourmi[0], 1);
				actionsFourmi.Collect(nourritureProche.getId(), StrategieConfig.MAX_FOOD);
				return ;
			}
			
			if (nourritureProche != null) {
				actionsFourmi.MoveTo(nourritureProche.getId());	
			}
		} else {
			actionsFourmi.Explore();
		}
	}

}
