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
	public boolean cogite(Fourmi fourmi) {
		List<Nourriture> nourritures= fourmi.getNourritureAProximite();
		Integer[] memoireFourmi = fourmi.getMemoire();
		System.out.println(": memoireFourmi " + memoireFourmi[0] + " | " + memoireFourmi[1]);

		// gestion du cycle
		int cptCycle = ++memoireFourmi[0];
		if(cptCycle >= StrategieConfig.MAX_CPT) {
			cptCycle = 0;
			memoireFourmi[0] = 0;
		}
		actionsFourmi.SetMemory(cptCycle, memoireFourmi[1]);
		// Retour au bercail
		if ((memoireFourmi[1] >> 7) == 1) {
			System.out.println(": Retour au bercail");
			FourmilieresVues fourmilieresAmie = fourmi.getFourmiliereAmie();
			if(fourmilieresAmie != null) {
				System.out.println(": Fourmiliere amie trouvé");
				actionsFourmi.MoveTo(fourmilieresAmie.getId());		
				return true;
			} // TODO : gérer changement type pheromone pour le retour
			List<Pheromone> pheromones = fourmi.getPheromonesAProximite();
			if(!pheromones.isEmpty()) {
				// recherche pheromone de la fourmi
				Pheromone pheromoneSelect = null;
				for(int i = 1; i < pheromones.size(); i++) {
					Pheromone pheromone = pheromones.get(i);
					if(pheromone.getIdFourmi() == (memoireFourmi[1] - 128)) {
						System.out.println(": MSB " + pheromone.getMSBtype());
						if(pheromoneSelect == null && pheromone.getMSBtype() == TypePheromone.NOTHING) {
							pheromoneSelect = pheromone;
							System.out.println(": phe select " + pheromoneSelect.getId());
						} else if(pheromoneSelect.getDist() > pheromone.getDist() && pheromone.getMSBtype() == TypePheromone.NOTHING){
							pheromoneSelect = pheromone;
							System.out.println(": phe select " + pheromoneSelect.getId());
						}
					}
				}
				
				if(pheromoneSelect != null) {
					if(pheromoneSelect.getZone().contains(StrategieConfig.NEAR)) {
						System.out.println(": Changement type pheromone");
						actionsFourmi.ChangePheromone(pheromoneSelect.id, memoireFourmi[1] + 128);
					} else {
						System.out.println(": Deplacement vers le pheromone " + pheromoneSelect.getId());
						actionsFourmi.MoveTo(pheromoneSelect.id);
					}
					return true;
				}
			} else {
				actionsFourmi.suicide();
				actionsFourmi.sendActions();
				return true;
			}
		}

		// Recherche de nourriture
		if(cptCycle % StrategieConfig.CYCLE_PHEROMONE == 0) {
			// A ameliorer selon etat fourmi
			System.out.println(": pheromone car " + cptCycle + "  ; " + cptCycle % StrategieConfig.CYCLE_PHEROMONE);
			actionsFourmi.PutPheromone(getTypePheromone(TypePheromone.NOTHING, memoireFourmi[1]));
			return true;
		}
		if (!nourritures.isEmpty()) {
			System.out.println(": bouffe trouvé");
			// Si il y a de la nourriture 
			Nourriture nourritureProche = nourritures.get(0);
			for(int i = 1; i < nourritures.size(); i++) {
				int dist = nourritures.get(i).getDist();
				if(dist < nourritureProche.getDist() ) {
					nourritureProche = nourritures.get(i);
				}
			}
			if (nourritureProche.getZone().contains(StrategieConfig.NEAR)) {
				System.out.println(": zone ok");
				actionsFourmi.SetMemory(memoireFourmi[0], memoireFourmi[1] + 128);
				actionsFourmi.Collect(nourritureProche.getId(), StrategieConfig.MAX_FOOD);
				return true;
			}
			actionsFourmi.MoveTo(nourritureProche.getId());
			return true;
		} 
		actionsFourmi.Explore();
		return true;
	}

	private Integer getTypePheromone(Integer typePheromone, Integer idFourmi) {
		if(typePheromone < 0 || typePheromone > 3 || idFourmi > 255 || idFourmi < 0) {
			throw new RuntimeException();
		}
		return (typePheromone << 8) + idFourmi;
	}

}
