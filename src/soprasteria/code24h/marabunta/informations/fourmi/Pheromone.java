package soprasteria.code24h.marabunta.informations.fourmi;

public class Pheromone {
	public Integer id;
	public String zone;
	public Integer dist;
	public Integer type;
	public Integer persistance;
	
	
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
	public Integer getPersistance() {
		return persistance;
	}
	public void setPersistance(Integer persistance) {
		this.persistance = persistance;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public int getMSBtype() {
		return this.type >> 8;
	}

	public void setMSBtype(int msbType) {
		if(msbType < 0 && msbType > 3) {
			throw new RuntimeException();
		}
		int typeActuel = (this.type << 24) >> 24;
		this.type = typeActuel + (msbType << 8);
	}

	public String toString() {
		return "Pheromone (id: " + id + ", zone: " + zone + ", dist: " + dist + ", type: " + type + ", persistance: " + persistance + ")";
	}
}
