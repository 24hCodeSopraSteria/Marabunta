package soprasteria.code24h.marabunta.strategie;

import java.util.List;
import java.util.Scanner;

import utils.TerminalReader;
import utils.TerminalWriter;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;
import soprasteria.code24h.marabunta.readers.fourmi.FourmiReader;
import soprasteria.code24h.marabunta.readers.fourmiliere.FourmiliereReader;
import soprasteria.code24h.marabunta.strategie.fourmi.StrategieFourmi;
import soprasteria.code24h.marabunta.strategie.fourmi.StrategieFourmiBasique;
import soprasteria.code24h.marabunta.strategie.fourmiliere.StrategieFourmiliere;
import soprasteria.code24h.marabunta.strategie.fourmiliere.StrategieFourmiliereBasique;


public class Main {

	public static void main(String[] args) {
		ActionsFourmis actionFourmi = new ActionsFourmis();

		TerminalReader tr = TerminalReader.getInstance();
		FourmiliereReader fourmiliereReader = new FourmiliereReader();
		FourmiReader fourmiReader = new FourmiReader();
		StrategieFourmiliere stratFourmiliere = new StrategieFourmiliereBasique();
		StrategieFourmi stratFourmi = new StrategieFourmiBasique();
		
		int run = 0;
		
		while(tr.notFinished)
		{
			// Obtention de toutes les commandes d'entree
            List<String> cmds = tr.readAll();
            
            // affichage pour debug
			for(String commandes : cmds) {
				System.out.println(": > " + commandes);
			}
			
			Fourmiliere fourmiliere = fourmiliereReader.read(cmds);
			if(fourmiliere != null) {
				// La fourmiliere est instancié
				System.out.println(": > " + fourmiliere.getStock());
				System.out.println(": > " + fourmiliere.getMemories()[0]);
				System.out.println(": > " + fourmiliere.getNbFourmis());
				stratFourmiliere.cogite(fourmiliere);
			} else {
				Fourmi fourmi = fourmiReader.read(cmds);
				System.out.println(": " + fourmi);
				if(fourmi != null) {
					// traitement fourmi
					stratFourmi.cogite(fourmi);
				}
			}
			
			run++;
		}
		
		
	}
	

}
