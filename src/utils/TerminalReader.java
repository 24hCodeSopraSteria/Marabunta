package utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalReader {
	public Scanner in = new Scanner(System.in);
	public boolean notFinished = true;
	public static TerminalReader me = null;

	private TerminalReader(){};
	public List<String> readAll() {
		List<String> listeDesCommandes = new ArrayList<String>();
		boolean finDeReception = false;
		
		while(!finDeReception) {
			String entree = in.nextLine();
			entree = entree.trim();
			
			if (entree.startsWith("END")) {
				finDeReception = true;
			}
			
			if (entree != "" && !entree.isEmpty()) {
				listeDesCommandes.add(entree);
			}
		}
		return listeDesCommandes;
	}


	public static TerminalReader getInstance() {
		if (TerminalReader.me == null) {
			me = new TerminalReader();
		}
		return me;
	}
	
	
}
