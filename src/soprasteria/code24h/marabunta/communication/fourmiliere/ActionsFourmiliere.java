package soprasteria.code24h.marabunta.communication.fourmiliere;

public class ActionsFourmiliere {
	
	/**
	 * Cr�e une nouvelle fourmi dans la fourmiliere <br>
	 * Le type choisi par cette commande restera le m�me tout au long de la vie de la fourmi<br>
	 * Exclusive : oui<br>
	 * Co�t : 5 unit�s de nourriture
	 * @param type Type de fourmi.
	 */
	public void AntNew(Integer type) {
		
	}
	
	/**
	 * Sort une fourmi de la fourmiliere<br>
	 * Cette fourmi doit exister dans la fourmili�re. Elle sort avec le maximum de stamina et emporte food unit�s de nourriture avec elle.<br>
	 * Exclusive : oui<br>
	 * Co�t : food + 1 unit� de nourriture
	 * @param type Type de fourmi.
	 * @param food Nourriture emport�e.
	 * @param m0 M�moire initiale de la fourmi.
	 * @param m1 M�moire initiale de la fourmi.
	 */
	public void AntOut(Integer type, Integer food, Integer m0, Integer m1) {
		
	}
	
	/**
	 * Modifie la m�moire de la fourmiliere<br>
	 * Exclusive : non<br>
	 * Co�t : 0
	 * @param m... Nombre compris entre 0 et 255 (max 20 parametres)
	 * @throws RuntimeException Si y'a plus de 20 param�tres de pass�s 
	 */
	public void SetMemory(Integer... m) {
		if(m.length > 20) {
			throw new RuntimeException();
		}
		
	}
}
