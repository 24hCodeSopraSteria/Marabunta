package soprasteria.code24h.marabunta.communication.fourmis;

import javax.management.Query;

import utils.TerminalWriter;

public class ActionsFourmis {
	
	private TerminalWriter tw = TerminalWriter.getInstance();
	/**
	 * Explore le terrain <br>
	 * Exclusive : oui <br>
	 * Coût : 1 unité
	 */
	public void Explore() {
		this.tw.add("EXPLORE");
		this.sendActions();
	}
	
	/**
	 * Tourne sur soi-même <br>
	 * Exclusive : oui <br>
	 * Coût : 1 unité <br>
	 * @param angle relative (-180 à 180)
	 */
	public void Turn(Integer angle) {
		this.tw.add("TURN " + angle);
		this.sendActions();
	}
	
	/**
	 * Se dirige vers un objet visible <br>
	 * Exclusive : oui <br>
	 * Coût : 2 unité <br>
	 * @param id Identifiant de l'objet indiqué par SEE_PHEROMONE, SEE_FOOD, SEE_ANT ou SEE_NEST
	 */
	public void MoveTo(Integer id) {
		this.tw.add("MOVE_TO " + id);
		this.sendActions();
	}
	
	/**
	 * Dépose une nouvelle phéromone <br>
	 * Exclusive : oui <br>
	 * Coût : 3 unité <br>
	 * @param type Type de phéromone (0 à 1023)
	 */
	public void PutPheromone(Integer type) {
		this.tw.add("PUT_PHEROMONE " + type);
		this.sendActions();
	}
	
	/**
	 * Modifie le type d'une phéromone existante. <br>
	 * La phéromone doit être dans le champ d'action (NEAR). Elle n'est pas rechargée à cette occasion. <br>
	 * Exclusive : oui <br>
	 * Coût : 2 unités <br>
	 * @param id Identifiant de l'objet indiqué par SEE_PHEROMONE
	 * @param type 	Type de phéromone (0 à 1023)
	 */
	public void ChangePheromone(Integer id, Integer type) {
		this.tw.add("CHANGE_PHEROMONE " + id + " " + type);
		this.sendActions();
	}
	
	/**
	 * Recharge une phéromone existante. <br>
	 * La phéromone doit être dans le champ d'action (NEAR). <br>
	 * Exclusive : oui <br>
	 * Coût : 1 <br>
	 * @param id Identifiant de l'objet indiqué par SEE_PHEROMONE
	 */
	public void RechargePheromone(Integer id) {
		this.tw.add("RECHARGE_PHEROMONE " + id);
		this.sendActions();
	}
	
	/**
	 * Collecte de la nourriture. <br>
	 * La source de nourriture doit être dans le champ d'action (NEAR). La quantité effectivement collectée est le minimum entre : <br>
	 *     - la quantité demandée,<br>
	 *     - la quantité restante dans la source de nourriture,<br>
	 *     - ce que peut encore collecter la fourmi.<br>
	 * N'oubliez pas que certaines sources de nourriture peuvent se tarir si la totalité de leurs ressources est consommée.<br>
	 * Exclusive : oui <br>
	 * Coût : 4 unités 
	 * @param id Identifiant de l'objet indiqué par SEE_FOOD
	 * @param quantity Quantité à prendre (limité par la capacité restante)
	 */
	public void Collect(Integer id, Integer quantity) {
		this.tw.add("COLLECT " + id + " " + quantity);
		this.sendActions();
	}
	
	/**
	 * Effectue une trophallaxie avec une autre fourmi. <br>
     * La fourmi avec qui l'échange est fait doit être dans le champ d'action (NEAR). La fourmi effectuant l'action perd du stock de nourriture, la fourmi qui reçoit l'action en gagne. Si l'échange contient plus de quantité que la fourmi ne peut en recevoir, l'excédant est perdu.<br>
     * Exclusive : oui<br>
     * Coût : égal à quantity
	 * @param id Identifiant de l'objet indiqué par SEE_ANT
	 * @param quantity 	Quantité à donner
	 */
	public void DoTrophallaxis(Integer id, Integer quantity) {
		this.tw.add("DO_TRAPHALLAXIS " + id + " " + quantity);
		this.sendActions();
	}
	
	/**
	 * Mange<br>
	 * Regenere 10x quantity unités de stamina dans la limite des capacités de la fourmi<br>
	 * Exclusive : oui<br>
	 * Coût : égal à quantity
	 * @param quantity
	 */
	public void Eat (Integer quantity) {
		this.tw.add("EAT " + quantity);
		this.sendActions();
	}
	
	/**
	 * Rentre dans la fourmilière <br>
	 * La fourmilière doit être dans le champ d'action (NEAR) et être de la même équipe que la fourmi.<br>
	 * La mémoire et le stock de nourriture sont transférés à la fourmilière.<br>
	 * Exclusive : oui<br>
	 * Coût : 2 unités
	 * @param id
	 */
	public void Nest (Integer id) {
		this.tw.add("NEST " + id);
		this.sendActions();
	}
	
	/**
	 * Attaque une autre fourmi.<br>
	 * La fourmi attaquée doit être dans le champ d'action (NEAR).<br>
	 * Exclusive : oui<br>
	 * Coût : voir tableau<br>
	 * <table border="1" class="docutils">
		<colgroup>
		<col width="33%" />
		<col width="27%" />
		<col width="40%" />
		</colgroup>
		<thead valign="bottom">
		<tr class="row-odd"><th class="head">Force</th>
		<th class="head">Coût</th>
		<th class="head">Dégâts</th>
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
	 * @param id 	Identifiant de l'objet indiqué par SEE_ANT
	 * @param force Force appliquée (voir tableau ci-dessus)
	 */
	public void attack (Integer id, Integer force) {
		this.tw.add("ATTACK " + id + " " + force); 
		this.sendActions();
	}
	
	/**
	 * Suicide la fourmi <br>
	 * Exclusive : non (prévoir appel à sendAction si pas d'autre appel exclusifs)<br> 
	 * Coût : 0 unité
	 */
	public void suicide () {
		this.tw.add("SUICIDE");
	}
	
	/**
	 * Modifie la mémoire de la fourmi<br>
	 * Exclusive : non (prévoir appel à sendAction si pas d'autre appel exclusifs)<br>
	 * Coût : 0 unités
	 * @param m0 Nombre compris entre 0 et 255 inclus.
	 * @param m1 Nombre compris entre 0 et 255 inclus.
	 * @throws RuntimeException Si une des deux valeurs est en dehors des bornes
	 */
	public void SetMemory(Integer m0, Integer m1) {
		if(m0 < 0 || m0 > 255 || m1 < 0 || m1 > 255) {
			throw new RuntimeException();
		}
		this.tw.add("SET_MEMORY " + m0 + " " + m1);
	}

	public void sendActions() {
		this.tw.sendAll();
	}
}
