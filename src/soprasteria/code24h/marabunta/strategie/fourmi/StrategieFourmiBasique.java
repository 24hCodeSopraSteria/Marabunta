package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.FourmilieresVues;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;
import soprasteria.code24h.marabunta.informations.fourmi.Pheromone;
import soprasteria.code24h.marabunta.informations.fourmi.TypePheromone;
import soprasteria.code24h.marabunta.strategie.StrategieConfig;

public class StrategieFourmiBasique implements StrategieFourmi {

	ActionsFourmis actionsFourmi = new ActionsFourmis();

	@Override
	public void cogite(Fourmi fourmi) {
		List<Nourriture> nourritures= fourmi.getNourritureAProximite();
		Integer[] memoireFourmi = fourmi.getMemoire();

		// gestion du cycle
		int cptCycle = memoireFourmi[0]++;
		if(cptCycle >= StrategieConfig.MAX_CPT) {
			cptCycle = 0;
			memoireFourmi[0] = 0;
		}
		actionsFourmi.SetMemory(0, memoireFourmi[1]);
		// Retour au bercail
		if ((memoireFourmi[1] << 7) != 0) {
			FourmilieresVues fourmilieresAmie = fourmi.getFourmiliereAmie();
			if(fourmilieresAmie != null) {
				actionsFourmi.MoveTo(fourmilieresAmie.getId());		
				return ;
			} // TODO : gérer changement type pheromone pour le retour
			List<Pheromone> pheromones = fourmi.getPheromonesAProximite();
			if(!pheromones.isEmpty()) {
				// recherche pheromone de la fourmi
				Pheromone pheromoneSelect = null;
				for(int i = 1; i < pheromones.size(); i++) {
					Pheromone pheromone = pheromones.get(i);
					if(pheromone.getIdFourmi() == memoireFourmi[1]) {
						if(pheromoneSelect == null && pheromone.getMSBtype() == TypePheromone.NOTHING) {
							pheromoneSelect = pheromone;
						} else if(pheromoneSelect.getDist() > pheromone.getDist() && pheromone.getMSBtype() == TypePheromone.NOTHING){
							pheromoneSelect = pheromone;
						}
					}
				}
				if(pheromoneSelect != null) {
					if(pheromoneSelect.zone == StrategieConfig.NEAR) {
						actionsFourmi.ChangePheromone(pheromoneSelect.id, TypePheromone.NOURRITURE_TROUVE);
					} else {
						actionsFourmi.MoveTo(pheromoneSelect.id);
					}
					return ;
				}
			}
		}

		// Recherche de nourriture
		if(cptCycle % StrategieConfig.CYCLE_PHEROMONE == 0) {
			// A ameliorer selon etat fourmi
			actionsFourmi.PutPheromone(getTypePheromone(TypePheromone.NOTHING, memoireFourmi[1]));
			return ;
		}
		if (!nourritures.isEmpty()) {

			// Si il y a de la nourriture 
			Nourriture nourritureProche = nourritures.get(0);
			for(int i = 1; i < nourritures.size(); i++) {
				int dist = nourritures.get(i).getDist();
				if(dist < nourritureProche.getDist() ) {
					nourritureProche = nourritures.get(i);
				}
			}
			if (nourritureProche.getZone() == StrategieConfig.NEAR) {
				actionsFourmi.SetMemory(memoireFourmi[0], 1);
				actionsFourmi.Collect(nourritureProche.getId(), StrategieConfig.MAX_FOOD);
				return ;
			}
			actionsFourmi.MoveTo(nourritureProche.getId());
		} 
		actionsFourmi.Explore();
	}

	private Integer getTypePheromone(Integer typePheromone, Integer idFourmi) {
		if(typePheromone < 0 || typePheromone > 3 || idFourmi > 255 || idFourmi < 0) {
			throw new RuntimeException();
		}
		return (typePheromone << 8) + idFourmi;
	}

}
