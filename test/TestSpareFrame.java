import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
class TestSpareFrame {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * A SpareFrame is certainly a Frame which is not a StrikeFrame or a
	 * CommonFrame. So the expected score of such a Frame is certainly between 10
	 * and 20 consisting of a sum of 10 plus the value of the first roll of the next
	 * Frame regarding itself. A SpareFrame as 10th Frame in a line leads to one
	 * bonus throw. Such a Frame should consider the follow up Frame of itself for
	 * his score.
	 */
	@Test
	void testSpareFrame() {
		/**
		 * TODO set frame variable as SpareFrame object with valid values and check
		 * properties a CommonFrame object should have.
		 */
	}

}
