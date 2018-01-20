package soprasteria.code24h.marabunta.strategie;

import java.util.Scanner;
import utils.TerminalReader;
import utils.TerminalWriter;
import soprasteria.code24h.marabunta.communication.fourmis.ActionsFourmis;


public class Main {

	public static void main(String[] args) {
		ActionsFourmis actionFourmi = new ActionsFourmis();

		TerminalReader tr = new TerminalReader();
		int run = 0;
		
		while(tr.notFinished)
		{
			run++;
			
			// Obtention de toutes les commandes d'entree
			tr.readAll();
			
			for(String commandes : tr.listeDesCommandes) {
				System.out.println("> : " + commandes);
			}
			
			// Création de la stratégie initiale : tous est dans tr.listeDesCommandes
			
			
			// Création de la strat�gie initiale
			

			TerminalWriter tw = new TerminalWriter();
			
			// Chargement des commandes � envoyer dans le TerminalWriter
			
			tw.add("ANT_NEW 0");
			tw.add("ANT_OUT 0 100 100 0");
			tw.add("EXPLORE");
			tw.add("END");
			
			
			// Envoi de la strat�gie initiale
			tw.sendAll();
			
			if (run > 3) {
				tr.notFinished = false;
			}
			
		}
		
		
	}
	

}
