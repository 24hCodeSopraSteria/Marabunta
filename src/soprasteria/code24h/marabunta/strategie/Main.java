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
		System.out.println("Hello world !");

		TerminalReader tr = new TerminalReader();
		FourmiliereReader fourmiliereReader = new FourmiliereReader();
		
		//while(tr.notFinished)
		{// Obtention de toutes les commandes d'entr�e
            List<String> cmds = tr.readAll();
//			for(String commande : cmds) {
//				System.out.println("Reception : " + commande);
//			}
			Fourmiliere fourmiliere = fourmiliereReader.read(cmds);
			if(fourmiliere != null) {
				// TODO strategie fourmilere
			} else {
				// TODO read fourmi
				// TODO strategie fourmie
			}
			
			// Création de la stratégie initiale
			

			TerminalWriter tw = new TerminalWriter();
			
			// Chargement des commandes à envoyer dans le TerminalWriter
			
			tw.add("ANT_NEW 0");
			tw.add("ANT_OUT 0 100 100 0");
			tw.add("EXPLORE");
			tw.add("END");
			
			
			// Envoi de la stratégie initiale
			tw.sendAll();
		}
		
		
		
	}
	

}
