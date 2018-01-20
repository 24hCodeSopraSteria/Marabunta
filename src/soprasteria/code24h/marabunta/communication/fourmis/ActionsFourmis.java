package soprasteria.code24h.marabunta.communication.fourmis;

public class ActionsFourmis {
	
	/**
	 * Explore le terrain <br>
	 * Exclusive : oui <br>
	 * Co�t : 1 unit�
	 */
	public void Explore() {
		
	}
	
	/**
	 * Tourne sur soi-m�me <br>
	 * Exclusive : oui <br>
	 * Co�t : 1 unit� <br>
	 * @param angle relative (-180 � 180)
	 */
	public void Turn(Integer angle) {
		
	}
	
	/**
	 * Se dirige vers un objet visible <br>
	 * Exclusive : oui <br>
	 * Co�t : 2 unit� <br>
	 * @param id Identifiant de l�objet indiqu� par SEE_PHEROMONE, SEE_FOOD, SEE_ANT ou SEE_NEST
	 */
	public void MoveTo(Integer id) {
		
	}
	
	/**
	 * D�pose une nouvelle ph�romone <br>
	 * Exclusive : oui <br>
	 * Co�t : 3 unit� <br>
	 * @param type Type de ph�romone (0 � 1023)
	 */
	public void PutPheromone(Integer type) {
		
	}
	
	/**
	 * Modifie le type d�une ph�romone existante. <br>
	 * La ph�romone doit �tre dans le champ d�action (NEAR). Elle n�est pas recharg�e � cette occasion. <br>
	 * Exclusive : oui <br>
	 * Co�t : 2 unit�s <br>
	 * @param id Identifiant de l�objet indiqu� par SEE_PHEROMONE
	 * @param type 	Type de ph�romone (0 � 1023)
	 */
	public void ChangePheromone(Integer id, Integer type) {
		
	}
	
	/**
	 * Recharge une ph�romone existante. <br>
	 * La ph�romone doit �tre dans le champ d�action (NEAR). <br>
	 * Exclusive : oui <br>
	 * Co�t : 1 <br>
	 * @param id Identifiant de l�objet indiqu� par SEE_PHEROMONE
	 */
	public void RechargePheromone(Integer id) {
		
	}

}
