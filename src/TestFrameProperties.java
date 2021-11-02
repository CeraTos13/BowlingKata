import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.model.FrameworkField;

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
class TestFrameProperties {
	private Frame frame;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		initializeFrame();
	}

	/**
	 * A CommonFrame is certainly a Frame which is not a StrikeFrame or a
	 * SpareFrame. So the expected score of such a Frame is certainly between 0 and
	 * 9 consisting of a sum of exactly two values. Such a Frame should not consider
	 * any other Frame for his score.
	 */
	@Test
	void testCommonFrame() {
		/**
		 * TODO set frame variable as CommonFrame object with valid values and check
		 * properties a CommonFrame object should have.
		 */
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

	/**
	 * TODO Initializing frame variable as Frame object.
	 */
	private void initializeFrame() {
		// TODO Auto-generated method stub

	}

}
