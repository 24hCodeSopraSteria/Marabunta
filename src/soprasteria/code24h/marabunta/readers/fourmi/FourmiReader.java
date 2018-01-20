package soprasteria.code24h.marabunta.readers.fourmi;

import soprasteria.code24h.marabunta.informations.fourmi.Fourmi;
import soprasteria.code24h.marabunta.readers.MarabuntaReader;

public class FourmiReader extends MarabuntaReader<Fourmi>{

	public FourmiReader() {
		super("BEGIN ANT");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseTo(String cmd, Fourmi info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fourmi createInstanceT() {
		return new Fourmi();
	}

}
