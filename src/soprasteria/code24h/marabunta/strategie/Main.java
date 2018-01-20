package soprasteria.code24h.marabunta.strategie;

import java.util.Scanner;

import utils.TerminalReader;
import utils.TerminalWriter;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");

		TerminalReader tr = new TerminalReader();
		
		//while(tr.notFinished)
		{// Obtention de toutes les commandes d'entrée
			tr.readAll();
			
//			for(String commandes : tr.listeDesCommandes) {
//				System.out.println("Reception : " + commandes);
//			}
			
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
