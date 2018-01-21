package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.FourmilieresVues;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;
import soprasteria.code24h.marabunta.strategie.StrategieConfig;

public class StrategieFourmiBasiqueVerifEcran implements StrategieFourmi {

	ActionsFourmis actionsFourmi = new ActionsFourmis();

	@Override
	public void cogite(Fourmi fourmi) {
		List<Nourriture> nourritures= fourmi.getNourritureAProximite();
		Integer[] memoireFourmi = fourmi.getMemoire();

		// gestion du cycle
		int cptCycle = memoireFourmi[0];
		actionsFourmi.SetMemory(++cptCycle, memoireFourmi[1]);
		
		if(cptCycle % StrategieConfig.CYCLE_PHEROMONE == 0) {
			actionsFourmi.PutPheromone(memoireFourmi[1]);
			return ;
		} else {
			// nourriture ?

			
			// On explore la carte
			actionsFourmi.Explore();
		}

	}

}
