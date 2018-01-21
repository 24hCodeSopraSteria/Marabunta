package utils;

import java.util.ArrayList;
import java.util.List;

public class TerminalWriter {
	private final List<String> commandes = new ArrayList<String>();
	private static TerminalWriter instance = null;

	private TerminalWriter() {}

	public void sendAll() {
		for (String commande : commandes) {
			System.out.print(commande);
			System.out.print('\n');
		}
		System.out.print("END\n");
		System.out.flush();
		commandes.clear();
	}
	
	public void add(String ajout) {
		this.commandes.add(ajout);
	}

	public static TerminalWriter getInstance() {
		if(TerminalWriter.instance == null) {
			TerminalWriter.instance = new TerminalWriter();
		}
		return TerminalWriter.instance;
	}

	public List<String> getCommandes() {
		return commandes;
	}
	
	
}
