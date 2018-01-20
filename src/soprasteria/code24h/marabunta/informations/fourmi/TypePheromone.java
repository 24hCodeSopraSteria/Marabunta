package soprasteria.code24h.marabunta.informations.fourmi;

public final class TypePheromone {
	private TypePheromone() {
		throw new RuntimeException("Interdit");
	}
	public static final int NOTHING = 0;
	public static final int NOURRITURE_TROUVE = 1;
	public static final int NOURRITURE_TERMINE = 2;
}
