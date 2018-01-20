package soprasteria.code24h.marabunta.communication.fourmiliere;

public class ActionsFourmiliere {
	
	/**
	 * Crée une nouvelle fourmi dans la fourmiliere <br>
	 * Le type choisi par cette commande restera le même tout au long de la vie de la fourmi<br>
	 * Exclusive : oui<br>
	 * Coût : 5 unités de nourriture
	 * @param type Type de fourmi.
	 */
	public void AntNew(Integer type) {
		
	}
	
	/**
	 * Sort une fourmi de la fourmiliere<br>
	 * Cette fourmi doit exister dans la fourmilière. Elle sort avec le maximum de stamina et emporte food unités de nourriture avec elle.<br>
	 * Exclusive : oui<br>
	 * Coût : food + 1 unité de nourriture
	 * @param type Type de fourmi.
	 * @param food Nourriture emportée.
	 * @param m0 Mémoire initiale de la fourmi.
	 * @param m1 Mémoire initiale de la fourmi.
	 */
	public void AntOut(Integer type, Integer food, Integer m0, Integer m1) {
		
	}
	
	/**
	 * Modifie la mémoire de la fourmiliere<br>
	 * Exclusive : non<br>
	 * Coût : 0
	 * @param m... Nombre compris entre 0 et 255 (max 20 parametres)
	 * @throws RuntimeException Si y'a plus de 20 paramètres de passés 
	 */
	public void SetMemory(Integer... m) {
		if(m.length > 20) {
			throw new RuntimeException();
		}
		
	}
}
