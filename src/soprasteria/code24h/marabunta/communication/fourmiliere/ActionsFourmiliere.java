package soprasteria.code24h.marabunta.communication.fourmiliere;

import utils.TerminalWriter;

public class ActionsFourmiliere {

	private TerminalWriter tw = TerminalWriter.getInstance();
	
	/**
	 * Crée une nouvelle fourmi dans la fourmiliere <br>
	 * Le type choisi par cette commande restera le même tout au long de la vie de la fourmi<br>
	 * Exclusive : oui<br>
	 * Coût : 5 unités de nourriture
	 * @param type Type de fourmi.
	 */
	public void AntNew(Integer type) {
		this.tw.add("ANT_NEW " + type);
		this.sendActions();
	}
	
	/**
	 * Sort une fourmi de la fourmiliere<br>
	 * Cette fourmi doit exister dans la fourmilière. Elle sort avec le maximum de stamina et emporte food unités de nourriture avec elle.<br>
	 * Exclusive : oui<br>
	 * Coût : food + 1 unité de nourriture
	 * @param type Type de fourmi.
	 * @param food Nourriture emportée.
	 * @param m0 Mémoire initiale de la fourmi. (0-255)
	 * @param m1 Mémoire initiale de la fourmi. (0-255)
	 */
	public void AntOut(Integer type, Integer food, Short m0, Short m1) {
		this.tw.add("ANT_OUT " + type + " " + food + " " + m0 + " " + m1);
		this.sendActions();
	}
	
	/**
	 * Modifie la mémoire de la fourmiliere<br>
	 * Exclusive : non<br> (prévoir appel à sendActions si pas d'action exclusive)
	 * Coût : 0
	 * @param memory... Nombre compris entre 0 et 255 (max 20 parametres)
	 * @throws RuntimeException Si y'a plus de 20 paramètres de passés ou valeur invalide
	 */
	public void SetMemory(Short... memory) {
		if(memory.length > 20) {
			throw new RuntimeException();
		}
		String str = "";
		for(int i = 0; i < memory.length; i++) {
			if(memory[i] > 255 || memory[i] < 0) {
				throw new RuntimeException();
			}
			str += memory[i] + " ";
		}
		this.tw.add("SET_MEMORY " + str);
	}

	public void sendActions() {
		this.tw.sendAll();
	}
}
