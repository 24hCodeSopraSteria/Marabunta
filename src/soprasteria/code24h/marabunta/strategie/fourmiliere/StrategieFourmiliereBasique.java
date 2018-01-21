package soprasteria.code24h.marabunta.strategie.fourmiliere;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

public class StrategieFourmiliereBasique implements StrategieFourmiliere {

	private ActionsFourmiliere actionsFourmiliere = new ActionsFourmiliere();

	@Override
	public void cogite(Fourmiliere fourmiliere) {
		int fourmisInterieur = fourmiliere.getNbFourmis();
		Integer[] memoire = fourmiliere.getMemories();
		System.out.println(": > interieur : " + fourmisInterieur + " exterieur : " + memoire[0]);
		if(memoire[0] < 20 && fourmisInterieur > 0) {
			memoire[0]++;
			actionsFourmiliere.SetMemory(memoire);
			actionsFourmiliere.AntOut(0, 5, 0, memoire[1]++);
		} else if (fourmisInterieur == 0) {
			actionsFourmiliere.AntNew(0);
		}
	}
}
