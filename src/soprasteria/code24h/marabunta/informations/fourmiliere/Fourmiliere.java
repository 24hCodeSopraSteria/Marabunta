package soprasteria.code24h.marabunta.informations.fourmiliere;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;

public class Fourmiliere {
	private final short[] memories;
	private BigInteger stock;
	private List<Fourmi> fourmiIn;
	
	public Fourmiliere() {
		memories = new short[20];
		stock = BigInteger.ZERO;
		fourmiIn = new ArrayList<Fourmi>();
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
	public short[] getMemories() {
		return memories;
	}

	/**
	 * @return the stock
	 */
	public BigInteger getStock() {
		return stock;
	}
}
