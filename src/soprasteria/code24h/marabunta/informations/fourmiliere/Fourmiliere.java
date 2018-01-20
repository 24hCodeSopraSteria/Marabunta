package soprasteria.code24h.marabunta.informations.fourmiliere;

import java.math.BigInteger;

public class Fourmiliere {
	private final byte[] memories;
	private BigInteger stock;
	
	public Fourmiliere() {
		memories = new byte[20];
		stock = BigInteger.ZERO;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(BigInteger stock) {
		this.stock = stock;
	}

	/**
	 * @return the memories
	 */
	public byte[] getMemories() {
		return memories;
	}

	/**
	 * @return the stock
	 */
	public BigInteger getStock() {
		return stock;
	}
}
