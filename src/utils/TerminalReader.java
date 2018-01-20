package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalReader {
	public Scanner in = new Scanner(System.in);
	public ArrayList<String> listeDesCommandes = new ArrayList<String>();
	
	
	public void readAll() {
		while(in.hasNextLine()) {
			listeDesCommandes.add(in.nextLine());
		}
	}
	
}
