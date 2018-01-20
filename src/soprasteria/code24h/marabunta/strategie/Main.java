package soprasteria.code24h.marabunta.strategie;

import java.util.Scanner;

import utils.TerminalReader;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world !");
		TerminalReader tr = new TerminalReader();
		tr.readAll();
		
		for(String commandes : tr.listeDesCommandes) {
			System.out.println("Reception : " + commandes);
		}
	}

}
