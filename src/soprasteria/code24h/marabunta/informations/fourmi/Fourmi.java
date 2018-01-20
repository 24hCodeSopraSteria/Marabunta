package soprasteria.code24h.marabunta.informations.fourmi;

import java.util.ArrayList;
import java.util.List;

import soprasteria.code24h.marabunta.informations.fourmiliere.Fourmiliere;

public class Fourmi {
	public Integer type;
	public Integer[] memoire = {0, 0};
	public boolean attaquee;
	public Integer stamina;
	public Integer stock;
	public List<Pheromone> pheromonesAProximite;
	public List<FourmisVues> fourmisAProximite;
	public List<FourmilieresVues> fourmilliereVoisines;
	public List<Nourriture> nourritureAProximite;
	
	public Fourmi() {
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
	
}
