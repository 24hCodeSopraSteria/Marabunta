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


public class Main {

	public static void main(String[] args) {
		ActionsFourmis actionFourmi = new ActionsFourmis();

		TerminalReader tr = TerminalReader.getInstance();
		FourmiliereReader fourmiliereReader = new FourmiliereReader();
		FourmiReader fourmiReader = new FourmiReader();
		
		int run = 0;
		
		while(tr.notFinished)
		{
			// Obtention de toutes les commandes d'entree
            List<String> cmds = tr.readAll();
            
            // affichage pour debug
			for(String commandes : cmds) {
				System.out.println("> : " + commandes);
			}
			
			Fourmiliere fourmiliere = fourmiliereReader.read(cmds);
			if(fourmiliere != null) {
				// La fourmiliere est instancié
			} else {
				Fourmi fourmi = fourmiReader.read(cmds);
				if(fourmi != null) {
					// TODO : Algorithme fourmi
				}
			}
			
			run++;
		}
		
		System.out.println("Nombre de run " + run);
		
		
	}
	

}
