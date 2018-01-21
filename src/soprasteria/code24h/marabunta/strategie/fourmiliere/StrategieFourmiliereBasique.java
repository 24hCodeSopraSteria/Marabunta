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
		System.out.println(": > interieur : " + fourmisInterieur + " exterieur : " + memoire[0]);
		if(memoire[0] < 50 && fourmisInterieur > 0) {
			memoire[0]++;
			int id = memoire[1]++;
			actionsFourmiliere.SetMemory(memoire);
			actionsFourmiliere.AntOut(0, 0, 0, id);
		} else if (fourmisInterieur == 0) {
			actionsFourmiliere.AntNew(TypeFourmi.EXPLORATRICE_BASIQUE);
		}
		return true;
	}
}
