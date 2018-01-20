package soprasteria.code24h.marabunta.strategie;

import java.util.List;
import java.util.Scanner;

import utils.TerminalReader;
import utils.TerminalWriter;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;
import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;
import soprasteria.code24h.marabunta.readers.fourmiliere.FourmiliereReader;


public class Main {

	public static void main(String[] args) {
		ActionsFourmis actionFourmi = new ActionsFourmis();

		TerminalReader tr = new TerminalReader();
		FourmiliereReader fourmiliereReader = new FourmiliereReader();
		
		int run = 0;
		
		while(tr.notFinished)
		{
			// Obtention de toutes les commandes d'entree
            List<String> cmds = tr.readAll();
            
            // affichage pour debug
//			for(String commandes : cmds) {
//				System.out.println("> : " + commandes);
//			}
            
			Fourmiliere fourmiliere = fourmiliereReader.read(cmds);
			if(fourmiliere != null) {
				// TODO strategie fourmilere
//				for(String commandes : cmds) {
//					System.out.println("> (fourmiliere): " + commandes);
//				}
			} else {
				// TODO read fourmi
				// TODO strategie fourmie
//				for(String commandes : cmds) {
//					System.out.println("> (fourmi): " + commandes);
//				}
			}
			
			run++;
			// Création de la strategie initiale
			

			TerminalWriter tw = new TerminalWriter();
			
			// Chargement des commandes a envoyer dans le TerminalWriter
			
//			tw.add("ANT_NEW 0");
//			tw.add("ANT_OUT 0 100 100 0");
//			tw.add("EXPLORE");
//			tw.add("END");
			
			
			// Envoi de la strategie initiale
			tw.sendAll();
//			
//			if (run > 5) {
//				tr.notFinished = false;
//			}
			
		}
		
		System.out.println("Nombre de run " + run);
		
		
	}
	

}
