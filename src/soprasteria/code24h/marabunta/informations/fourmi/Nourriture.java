package soprasteria.code24h.marabunta.informations.fourmi;

public class Nourriture {
	public Integer id;
	public String zone;
	public Integer dist;
	public Integer amount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public Integer getDist() {
		return dist;
	}
	public void setDist(Integer dist) {
		this.dist = dist;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
	public String toString() {
		return "Nourriture (id: " + id + ", zone: " + zone +", dist: " + dist + ", amount: " + amount + ")";
	}
	
}
