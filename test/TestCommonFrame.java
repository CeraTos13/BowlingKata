import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
class TestCommonFrame {
	Frame frame;
	ArrayList<ArrayList<Integer>> validValues = new ArrayList<ArrayList<Integer>>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		initilizeSomeValuePairs();

	}

	/**
	 * A CommonFrame is certainly a Frame which is not a StrikeFrame or a
	 * SpareFrame. So the expected score of such a Frame is certainly between 0 and
	 * 9 consisting of a sum of exactly two values. Such a Frame should not consider
	 * any other Frame for his score.
	 */
	@Test
	void testGetScore() {
		for (ArrayList<Integer> valuePair : validValues) {
			int expectedScore = valuePair.get(0) + valuePair.get(1);
			frame = new CommonFrame(valuePair.get(0), valuePair.get(1));
			// System.out.println(String.format("%d,%d",
			// frame.getFirstRoll(),frame.getSecondRoll()));
			assertEquals("testGetScore()", expectedScore, frame.getScore());
		}
	}

	public void initilizeSomeValuePairs() {
		ArrayList<Integer> valuePair = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				valuePair.add(i);
				valuePair.add(j);
				validValues.add(valuePair);
				valuePair = new ArrayList<>();
			}
		}

	}

}
