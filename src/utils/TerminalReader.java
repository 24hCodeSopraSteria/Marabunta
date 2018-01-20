package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalReader {
	public Scanner in = new Scanner(System.in);
	public boolean notFinished = true;
	
	
	public List<String> readAll() {
		List<String> listeDesCommandes = new ArrayList<String>();
		boolean finDeReception = false;
		while(in.hasNextLine()) {
			String entree = in.nextLine();
			if (entree.equals("END")) {
				finDeReception = true;
			}
			listeDesCommandes.add(entree);
		}
		return listeDesCommandes;
	}
	
}
