package soprasteria.code24h.marabunta.informations.fourmiliere;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;

public class Fourmiliere {
	private final short[] memories;
	private BigInteger stock;
	private Integer nbFourmis;
	private List<Fourmi> fourmiIn;
	
	public Fourmiliere() {
		memories = new short[20];
		stock = BigInteger.ZERO;
		fourmiIn = new ArrayList<Fourmi>();
		nbFourmis = 0;
	}

	/**
	 * @return the fourmiIn
	 */
	public List<Fourmi> getFourmiIn() {
		return fourmiIn;
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
	
	/**
	 * @return the nbFourmis
	 */
	public Integer getNbFourmis() {
		return nbFourmis;
	}

	/**
	 * @param nbFourmis the nbFourmis to set
	 */
	public void setNbFourmis(Integer nbFourmis) {
		this.nbFourmis = nbFourmis;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Fourmiliere (");
		strBuilder.append("stock : ").append(stock).append(", ");
		strBuilder.append("nbFourmis : ").append(nbFourmis).append(", ");
		strBuilder.append("memories : [");
		for(int i = 0; i < memories.length - 1; i++) {
			strBuilder.append(memories[i]).append(", ");
		}
		strBuilder.append(memories[memories.length - 1]);
		strBuilder.append(']');
		strBuilder.append(")");
		return strBuilder.toString();
	}
}
