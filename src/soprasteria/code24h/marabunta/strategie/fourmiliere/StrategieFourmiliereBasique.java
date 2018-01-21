package soprasteria.code24h.marabunta.strategie.fourmiliere;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

public class StrategieFourmiliereBasique implements StrategieFourmiliere {

	private ActionsFourmiliere actionsFourmiliere = new ActionsFourmiliere();

	@Override
	public void cogite(Fourmiliere fourmiliere) {
		int fourmisInterieur = fourmiliere.getNbFourmis();
		Integer fourmisExterieur = fourmiliere.getMemories()[0];
		
		System.out.println(": > interieur : " + fourmisInterieur + " exterieur : " + fourmisExterieur);
		if(fourmisExterieur < 20 && fourmisInterieur > 0) {
			actionsFourmiliere.SetMemory(++fourmisExterieur);
			actionsFourmiliere.AntOut(0, 5, 0, 0);
		} else if (fourmisInterieur == 0) {
			actionsFourmiliere.AntNew(0);
		}
	}
}
