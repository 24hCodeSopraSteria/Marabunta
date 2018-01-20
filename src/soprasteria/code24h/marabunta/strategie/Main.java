package soprasteria.code24h.marabunta.strategie;

import java.util.Scanner;

import utils.TerminalReader;
import utils.TerminalWriter;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		
		// Obtention de toutes les commandes d'entrée
		TerminalReader tr = new TerminalReader();
		tr.readAll();
		
		for(String commandes : tr.listeDesCommandes) {
			System.out.println("Reception : " + commandes);
		}
		
		// Création de la stratégie initiale
		

		TerminalWriter tw = new TerminalWriter();
		
		// Chargement des commandes à envoyer dans le TerminalWriter
		tw.add("Salut");
		tw.add("huhuhut");
		
		
		// Envoi de la stratégie initiale
		tw.sendAll();
		
	}

}
