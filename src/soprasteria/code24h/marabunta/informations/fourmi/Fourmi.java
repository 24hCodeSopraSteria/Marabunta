package soprasteria.code24h.marabunta.informations.fourmi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fourmi {
	private Integer type;
	private Integer[] memoire = {0, 0};
	private boolean attaquee;
	private Integer stamina;
	private Integer stock;
	private List<Pheromone> pheromonesAProximite;
	private List<FourmisVues> fourmisAProximite;
	private List<FourmilieresVues> fourmilliereVoisines;
	private List<Nourriture> nourritureAProximite;
	
	public Fourmi() {
		type = 0;
		attaquee = false;
		stamina = 0;
		stock = 0;
		this.pheromonesAProximite = new ArrayList<Pheromone>();
		this.fourmisAProximite = new ArrayList<FourmisVues>();
		this.fourmilliereVoisines = new ArrayList<FourmilieresVues>();
		this.nourritureAProximite = new ArrayList<Nourriture>();
	}
	
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer[] getMemoire() {
		return memoire;
	}
	public void setMemoire(Integer[] memoire) {
		this.memoire = memoire;
	}
	public boolean isAttaquee() {
		return attaquee;
	}
	public void setAttaquee(boolean attaquee) {
		this.attaquee = attaquee;
	}
	public Integer getStamina() {
		return stamina;
	}
	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public List<Pheromone> getPheromonesAProximite() {
		return pheromonesAProximite;
	}
	public void setPheromonesAProximite(List<Pheromone> pheromonesAProximite) {
		this.pheromonesAProximite = pheromonesAProximite;
	}
	public List<FourmilieresVues> getFourmilliereVoisines() {
		return fourmilliereVoisines;
	}
	public void setFourmilliereVoisines(List<FourmilieresVues> fourmilliereVoisines) {
		this.fourmilliereVoisines = fourmilliereVoisines;
	}
	public List<Nourriture> getNourritureAProximite() {
		return nourritureAProximite;
	}
	public void setNourritureAProximite(List<Nourriture> nourritureAProximite) {
		this.nourritureAProximite = nourritureAProximite;
	}
	/**
	 * @return the fourmisAProximite
	 */
	public List<FourmisVues> getFourmisAProximite() {
		return fourmisAProximite;
	}
	
	/**
	 * Donne la fourmiliere amie la plus proche.
	 * @return la vue de la fourmiliere amie la plus proche ou null, si aucune n'est visible.
	 */
	public FourmilieresVues getFourmiliereAmie() {
		List<FourmilieresVues> fourmilieresAmies = fourmilliereVoisines.stream().filter(f -> f.isFriend()).collect(Collectors.toList());
		if(!fourmilieresAmies.isEmpty()) {
			// trouvons la plus proche
			FourmilieresVues fourmiliereProche = fourmilieresAmies.get(0);
			for(int i = 1; i < fourmilieresAmies.size(); i++) {
				int distMin = fourmiliereProche.getDist();
				int dist = fourmilieresAmies.get(i).getDist();
				if(dist < distMin) {
					fourmiliereProche = fourmilieresAmies.get(i);
				}
			}
			return fourmiliereProche;
		}
		return null;
	}
	
	public String toString() {
		return "Fourmi (type: " + type + ", memoire: " + memoire[0] + ", " + memoire[1] + ", attaquee: " + attaquee + ", stamina: " + stamina + ", stock: " + stock + ", pheromonesAProximite: " + pheromonesAProximite + ", fourmisAProximite: " + fourmisAProximite + ", fourmilliereVoisines: " + fourmilliereVoisines + ", nourritureAProximite: " + nourritureAProximite + ")";
	}
	
	public Nourriture nourritureLaPlusProche() {
		Nourriture nourritureProche = null;
		if (nourritureAProximite.size() > 0) {
			nourritureProche = nourritureAProximite.get(0);
			for(int i = 1; i < nourritureAProximite.size(); i++) {
				int dist = nourritureAProximite.get(i).getDist();
				if(dist < nourritureProche.getDist() ) {
					nourritureProche = nourritureAProximite.get(i);
				}
			}
		}
		return nourritureProche;
	}
}
