package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalReader {
	public Scanner in = new Scanner(System.in);
	public ArrayList<String> listeDesCommandes = new ArrayList<String>();
	public boolean notFinished = true;
	
	
	public void readAll() {
		boolean finDeReception = false;
		while(in.hasNextLine()) {
			String entree = in.nextLine();
			if (entree.equals("END")) {
				finDeReception = true;
			}
			listeDesCommandes.add(entree);
		}
		
	}
	
}
