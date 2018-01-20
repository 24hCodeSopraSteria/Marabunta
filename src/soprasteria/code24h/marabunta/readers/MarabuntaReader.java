package soprasteria.code24h.marabunta.readers;

import java.util.List;

public abstract class MarabuntaReader<T> {
	private final String startCmd;
	
	public MarabuntaReader(String startCmd) {
		this.startCmd = startCmd;
	}
	
	public T read(List<String> commandes) {
		T info = null;
		if(!commandes.isEmpty() && startCmd.equalsIgnoreCase(commandes.get(0))) {
			info = createInstanceT();
			for(String cmd : commandes) {
				parseTo(cmd, info);
			}
		}
		return info;
	}
	
	public abstract void parseTo(String cmd, T info);
	public abstract T createInstanceT();
}
