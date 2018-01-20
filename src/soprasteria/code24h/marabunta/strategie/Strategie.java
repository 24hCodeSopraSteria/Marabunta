package soprasteria.code24h.marabunta.strategie;

import java.util.List;

/**
 * Stratégie pour un élément (fourmi ou fourmilière).
 * @param <T> Foumi ou Fourmilere.
 */
public interface Strategie<T> {
	/**
	 * Exécute l'intelligence d'un élément
	 * @param elem l'élément
	 * @return void (pour le moment)
	 */
	public void cogite(T elem);
}
