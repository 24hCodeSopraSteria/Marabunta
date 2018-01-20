package utils;

/**
 * Mainpulateur de bits sur un integer représentant des flags.
 */
public final class IntegerBitFlagManipulator {
	/**
	 * Vérifie si un ou plusieurs flags sont activés dans un integer.
	 * 
	 * @param memoire l'integer contenant les flags
	 * @param flags les flags qu'on souhaite activés
	 * @return vrai si tous les flags sont activés, faux si au moins un flag est désactivé
	 */
	public static boolean checkFlag(Integer memoire, int flags) {
		return ((int) memoire & flags) == flags;
	}
}
