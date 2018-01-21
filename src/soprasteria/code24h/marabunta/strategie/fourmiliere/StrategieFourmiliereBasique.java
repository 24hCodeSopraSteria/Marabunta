package soprasteria.code24h.marabunta.strategie.fourmiliere;

import java.math.BigInteger;
import java.util.List;

import soprasteria.code24h.marabunta.communication.fourmiliere.ActionsFourmiliere;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.TypeFourmi;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

public class StrategieFourmiliereBasique implements StrategieFourmiliere {

	private ActionsFourmiliere actionsFourmiliere = new ActionsFourmiliere();

	@Override
	public boolean cogite(Fourmiliere fourmiliere) {
		int fourmisInterieur = fourmiliere.getNbFourmis();
		Integer[] memoire = fourmiliere.getMemories();
		List<Fourmi> fourmiIn = fourmiliere.getFourmiIn();
		// System.out.println(": > interieur : " + fourmisInterieur + " exterieur : " + memoire[0]);

		if(fourmiIn.size() > 0) {
			memoire[0] -= fourmiIn.size();
		}

		if (fourmisInterieur == 0 && fourmiliere.getStock().longValue() > 100) {
			actionsFourmiliere.AntNew(TypeFourmi.EXPLORATRICE_BASIQUE);
			return true;
		}
		if(memoire[0] < 10 && fourmisInterieur > 0) {
			memoire[0]++;
			int id = memoire[1]++;
			if(id >= 127) {
				memoire[1] = 0;
			}
			actionsFourmiliere.SetMemory(memoire);
			actionsFourmiliere.AntOut(0, 0, 0, id);
			return true;
		}
		memoire[2]++;
		if(memoire[2] >= 255) {
			memoire[2] = 0;
			actionsFourmiliere.SetMemory(memoire);
			actionsFourmiliere.AntNew(TypeFourmi.EXPLORATRICE_BASIQUE);
		}
		actionsFourmiliere.SetMemory(memoire);

		actionsFourmiliere.sendActions();
		return true;
	}
}
