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
class TestStrikeFrame {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * A StrikeFrame is certainly a Frame which is not a SpareFrame or a
	 * CommonFrame. So the expected score of such a Frame is certainly between 10
	 * and 30. A StrikeFrame as 10th Frame in a line leads to two bonus throw. Such
	 * a Frame should consider up to two follow up Frames of itself for his score.
	 * Consideration of: -One follow up Frame: StrikeFrame -> CommonFrame;
	 * StrikeFrame -> SpareFrame; -Two follow up Frames: StrikeFrame -> StrikeFrame;
	 */
	@Test
	void testStrikeFrame() {
		/**
		 * TODO set frame variable as StrikeFrame object with valid values and check
		 * properties a CommonFrame object should have.
		 */

	}

}
