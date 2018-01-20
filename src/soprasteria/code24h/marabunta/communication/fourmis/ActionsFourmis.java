package soprasteria.code24h.marabunta.communication.fourmis;

public class ActionsFourmis {
	
	/**
	 * Explore le terrain <br>
	 * Exclusive : oui <br>
	 * Coût : 1 unité
	 */
	public void Explore() {
		
	}
	
	/**
	 * Tourne sur soi-même <br>
	 * Exclusive : oui <br>
	 * Coût : 1 unité <br>
	 * @param angle relative (-180 à 180)
	 */
	public void Turn(Integer angle) {
		
	}
	
	/**
	 * Se dirige vers un objet visible <br>
	 * Exclusive : oui <br>
	 * Coût : 2 unité <br>
	 * @param id Identifiant de l’objet indiqué par SEE_PHEROMONE, SEE_FOOD, SEE_ANT ou SEE_NEST
	 */
	public void MoveTo(Integer id) {
		
	}
	
	/**
	 * Dépose une nouvelle phéromone <br>
	 * Exclusive : oui <br>
	 * Coût : 3 unité <br>
	 * @param type Type de phéromone (0 à 1023)
	 */
	public void PutPheromone(Integer type) {
		
	}
	
	/**
	 * Modifie le type d’une phéromone existante. <br>
	 * La phéromone doit être dans le champ d’action (NEAR). Elle n’est pas rechargée à cette occasion. <br>
	 * Exclusive : oui <br>
	 * Coût : 2 unités <br>
	 * @param id Identifiant de l’objet indiqué par SEE_PHEROMONE
	 * @param type 	Type de phéromone (0 à 1023)
	 */
	public void ChangePheromone(Integer id, Integer type) {
		
	}
	
	/**
	 * Recharge une phéromone existante. <br>
	 * La phéromone doit être dans le champ d’action (NEAR). <br>
	 * Exclusive : oui <br>
	 * Coût : 1 <br>
	 * @param id Identifiant de l’objet indiqué par SEE_PHEROMONE
	 */
	public void RechargePheromone(Integer id) {
		
	}

}
