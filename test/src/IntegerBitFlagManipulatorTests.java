import static org.junit.Assert.*;

import org.junit.Test;

import utils.IntegerBitFlagManipulator;


public class IntegerBitFlagManipulatorTests {

	@Test
	public void test() {
		Integer in = 5;
		assertTrue(IntegerBitFlagManipulator.checkFlag(in, 5));
		assertTrue(IntegerBitFlagManipulator.checkFlag(in, 1));
		assertTrue(IntegerBitFlagManipulator.checkFlag(in, 4));
		assertFalse(IntegerBitFlagManipulator.checkFlag(in, 2));
		assertFalse(IntegerBitFlagManipulator.checkFlag(in, 3));
	}

}
