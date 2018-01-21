package soprasteria.code24h.marabunta.strategie;

import java.util.List;
import java.util.Scanner;

import utils.TerminalReader;
import utils.TerminalWriter;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmi.TypeFourmi;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;
import soprasteria.code24h.marabunta.readers.fourmi.FourmiReader;
import soprasteria.code24h.marabunta.readers.fourmiliere.FourmiliereReader;
import soprasteria.code24h.marabunta.strategie.fourmi.StrategieFourmi;
import soprasteria.code24h.marabunta.strategie.fourmi.StrategieFourmiBasique;
import soprasteria.code24h.marabunta.strategie.fourmi.StrategieFourmiRecolteuse;
import soprasteria.code24h.marabunta.strategie.fourmiliere.StrategieFourmiliere;
import soprasteria.code24h.marabunta.strategie.fourmiliere.StrategieFourmiliereBasique;


public class Main {

	public static void main(String[] args) {
		TerminalReader tr = TerminalReader.getInstance();
		FourmiliereReader fourmiliereReader = new FourmiliereReader();
		FourmiReader fourmiReader = new FourmiReader();
		StrategieFourmiliere stratFourmiliere = new StrategieFourmiliereBasique();
		StrategieFourmi stratFourmiBasique = new StrategieFourmiBasique();
		StrategieFourmi stratFourmiRecolt = new StrategieFourmiRecolteuse();
		
		while(tr.notFinished) {
			// Obtention de toutes les commandes d'entree
            List<String> cmds = tr.readAll();
            
			
			Fourmiliere fourmiliere = fourmiliereReader.read(cmds);
			if(fourmiliere != null) {
				// La fourmiliere est instancié
				stratFourmiliere.cogite(fourmiliere);
				continue;
			} else {
				Fourmi fourmi = fourmiReader.read(cmds);
				if(fourmi != null) {
					// traitement fourmi
					switch(fourmi.getType()) {
						case TypeFourmi.EXPLORATRICE_BASIQUE :
							stratFourmiBasique.cogite(fourmi);
							break;
						case TypeFourmi.RECOLTEUSE :
							stratFourmiRecolt.cogite(fourmi);
							break;
					}
				}
			}
		}
	}
}
