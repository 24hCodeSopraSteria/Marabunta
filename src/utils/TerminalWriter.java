package utils;

import java.util.ArrayList;

public class TerminalWriter {
	public ArrayList<String> commandes = new ArrayList<String>();
	
	public void sendAll() {
		for (String commande : commandes) {
			System.out.println(commande);
		}
	}
	
	public void add(String ajout) {
		this.commandes.add(ajout);
	}
}
