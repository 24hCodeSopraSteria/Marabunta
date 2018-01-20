package utils;

import java.util.ArrayList;
import java.util.List;

public class TerminalWriter {
	private List<String> commandes = new ArrayList<String>();
	private static TerminalWriter instance = null;

	private TerminalWriter() {}

	public void sendAll() {
		for (String commande : commandes) {
			System.out.print(commande + "\n");
		}
		System.out.print("END\n");
		System.out.flush();
		commandes = new ArrayList<String>();
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
}
