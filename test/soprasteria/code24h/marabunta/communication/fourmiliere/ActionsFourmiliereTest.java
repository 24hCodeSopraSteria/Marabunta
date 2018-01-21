package soprasteria.code24h.marabunta.communication.fourmiliere;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.TerminalWriter;

public class ActionsFourmiliereTest {

	@Test
	public void test() {
		ActionsFourmiliere afm = new ActionsFourmiliere();
		Integer[] in = new Integer[] {5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		afm.SetMemory(in);
		
		TerminalWriter tw = TerminalWriter.getInstance();
//		System.out.println("expected: SET_MEMORY 5 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
//		System.out.println("actual  : " + tw.getCommandes().get(0));
		assertEquals("SET_MEMORY 5 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0", tw.getCommandes().get(0));
	}

}
