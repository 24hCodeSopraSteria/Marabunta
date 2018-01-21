package soprasteria.code24h.marabunta.strategie.fourmiliere;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.informations.fourmi.TypeFourmi;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

public class StrategieFourmiliereBasique implements StrategieFourmiliere {

	private ActionsFourmiliere actionsFourmiliere = new ActionsFourmiliere();

	@Override
	public boolean cogite(Fourmiliere fourmiliere) {
		int fourmisInterieur = fourmiliere.getNbFourmis();
		Integer[] memoire = fourmiliere.getMemories();
		// System.out.println(": > interieur : " + fourmisInterieur + " exterieur : " + memoire[0]);
		if (fourmisInterieur == 0) {
			if(memoire[2] < 250) {
				memoire[2]++;
			} else {
				memoire[3]++;
				memoire[3] %= 250;				
			}
			actionsFourmiliere.SetMemory(memoire);
			if(memoire[3] == 0) {
				actionsFourmiliere.AntNew(TypeFourmi.EXPLORATRICE_BASIQUE);
				return true;
			}
		}
		if(memoire[0] < 5 && fourmisInterieur > 0) {
			memoire[0]++;
			int id = memoire[1]++;
			if(id >= 127) {
				memoire[1] = 0;
			}
			actionsFourmiliere.SetMemory(memoire);
			actionsFourmiliere.AntOut(0, 0, 0, id);
			return true;
		}
		actionsFourmiliere.sendActions();
		return true;
	}
}
