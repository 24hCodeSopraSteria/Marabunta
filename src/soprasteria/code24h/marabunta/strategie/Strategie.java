package soprasteria.code24h.marabunta.strategie;

/**
 * Stratégie pour un élément (fourmi ou fourmilière).
 * @param <T> Foumi ou Fourmilere.
 */
public interface Strategie<T> {
	/**
	 * Exécute l'intelligence d'un élément
	 * @param elem l'élément
	 * @return vrai si une action exclusive est survenue, faux sinon (pour le moment)
	 */
	public boolean cogite(T elem);
}
