package soprasteria.code24h.marabunta.informations.fourmi;

public class FourmilieresVues {
	public Integer id;
	public String zone;
	public Integer dist;
	public boolean friend;
	
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
	public boolean isFriend() {
		return friend;
	}
	public void setFriend(boolean friend) {
		this.friend = friend;
	}
	
	public String toString() {
		return "FourmilieresVues (id: " + id + ", zone: " + zone +", dist: " + dist + ", friend: " + friend + ")";
	}
}
