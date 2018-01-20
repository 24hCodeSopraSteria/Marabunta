package soprasteria.code24h.marabunta.strategie.fourmi;

import java.util.LinkedList;
import java.util.List;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.Nourriture;

public class StrategieFourmiBasique implements StrategieFourmi {

	ActionsFourmis actionsFourmi = new ActionsFourmis();

	@Override
	public void cogite(Fourmi fourmi) {
		List<Nourriture> nourritures= fourmi.getNourritureAProximite();
		if (!nourritures.isEmpty()) {
			Nourriture nourritureProche = nourritures.get(0);
			for(int i = 1; i < nourritures.size(); i++) {
				int dist = nourritures.get(i).getDist();
				if(dist < nourritureProche.getDist() ) {
					nourritureProche = nourritures.get(i);
				}
			}
			actionsFourmi.MoveTo(nourritureProche.getId());
		} else {
			actionsFourmi.Explore();
		}
	}

}
