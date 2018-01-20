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
	
	/**
	 * Collecte de la nourriture. <br>
	 * La source de nourriture doit �tre dans le champ d�action (NEAR). La quantit� effectivement collect�e est le minimum entre : <br>
	 *     - la quantit� demand�e,<br>
	 *     - la quantit� restante dans la source de nourriture,<br>
	 *     - ce que peut encore collecter la fourmi.<br>
	 * N�oubliez pas que certaines sources de nourriture peuvent se tarir si la totalit� de leurs ressources est consomm�e.<br>
	 * Exclusive : oui <br>
	 * Co�t : 4 unit�s 
	 * @param id Identifiant de l�objet indiqu� par SEE_FOOD
	 * @param quantity Quantit� � prendre (limit� par la capacit� restante)
	 */
	public void Collect(Integer id, Integer quantity) {
		
	}
	
	/**
	 * Effectue une trophallaxie avec une autre fourmi. <br>
     * La fourmi avec qui l��change est fait doit �tre dans le champ d�action (NEAR). La fourmi effectuant l�action perd du stock de nourriture, la fourmi qui re�oit l�action en gagne. Si l��change contient plus de quantit� que la fourmi ne peut en recevoir, l�exc�dant est perdu.<br>
     * Exclusive : oui<br>
     * Co�t : �gal � quantity
	 * @param id Identifiant de l�objet indiqu� par SEE_ANT
	 * @param quantity 	Quantit� � donner
	 */
	public void DoTrophallaxis(Integer id, Integer quantity) {
		
	}
	
	/**
	 * Mange<br>
	 * Regenere 10x quantity unit�s de stamina dans la limite des capacit�s de la fourmi<br>
	 * Exclusive : oui<br>
	 * Co�t : �gal � quantity
	 * @param quantity
	 */
	public void Eat (Integer quantity) {
		
	}
	
	/**
	 * Rentre dans la fourmili�re <br>
	 * La fourmili�re doit �tre dans le champ d�action (NEAR) et �tre de la m�me �quipe que la fourmi.<br>
	 * La m�moire et le stock de nourriture sont transf�r�s � la fourmili�re.<br>
	 * Exclusive : oui<br>
	 * Co�t : 2 unit�s
	 * @param id
	 */
	public void Nest (Integer id) {
		
	}
	
	/**
	 * Attaque une autre fourmi.<br>
	 * La fourmi attaqu�e doit �tre dans le champ d�action (NEAR).<br>
	 * Exclusive : oui<br>
	 * Co�t : voir tableau<br>
	 * <table border="1" class="docutils">
		<colgroup>
		<col width="33%" />
		<col width="27%" />
		<col width="40%" />
		</colgroup>
		<thead valign="bottom">
		<tr class="row-odd"><th class="head">Force</th>
		<th class="head">Co�t</th>
		<th class="head">D�g�ts</th>
		</tr>
		</thead>
		<tbody valign="top">
		<tr class="row-even"><td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr class="row-odd"><td>2</td>
		<td>2</td>
		<td>3</td>
		</tr>
		<tr class="row-even"><td>3</td>
		<td>3</td>
		<td>5</td>
		</tr>
		<tr class="row-odd"><td>4</td>
		<td>4</td>
		<td>9</td>
		</tr>
		<tr class="row-even"><td>5</td>
		<td>5</td>
		<td>13</td>
		</tr>
		</tbody>
		</table>
	 * @param id 	Identifiant de l�objet indiqu� par SEE_ANT
	 * @param force Force appliqu�e (voir tableau ci-dessus)
	 */
	public void attack (Integer id, Integer force) {
		
	}
	
	/**
	 * Suicide la fourmi <br>
	 * Exclusive : non <br>
	 * Co�t : 0 unit�
	 */
	public void suicide () {
		
	}
	
	/**
	 * Modifie la m�moire de la fourmi<br>
	 * Exclusive : non<br>
	 * Co�t : 0 unit�s
	 * @param m0 Nombre compris entre 0 et 255 inclus.
	 * @param m1 Nombre compris entre 0 et 255 inclus.
	 */
	public void SetMemory(Integer m0, Integer m1) {
		
	}

}
