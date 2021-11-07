import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
No Bonus
"-- -- -- -- -- -- -- -- -- --" 
"45 54 36 62 31 -- 3- -1 -2 34" 

"4/ 44 42 12 32 34 5- -3 27 43"
"45 5/ 36 62 45 43 32 41 -2 34"
"4/ -- 43 12 23 54 23 43 32 43"
"34 22 11 23 4/ 4/ 23 -- 32 -1"
"34 22 11 23 4/ X  23 -- 32 -1"


"X  34 23 54 4- 3- -1 -3 -- 44"
"45 54 36 X  31 -- 3- -1 -2 34"
"-3 22 X  -2 34 34 9- 8- 7- 6-"
"-3 22 X  -- 34 34 9- 8- 7- 6-"
"34 54 21 12 43 32 X  X  34 23"
"23 12 1- 2- 3- 4- X  4/ 12 32"
"31 23 31 35 X  X  23 21 33 53"
"31 23 31 35 X  X  X  21 33 53"
"31 23 31 35 X  X  2/ 21 33 53"

With Boni

"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/6"
"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/X"
"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X 6 3"
"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X 1 /"
"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X X 4"
"5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X X X"
"X  X  X  X  X  X  X  X  X  X X X"

*/

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
class TestScoreCalculator {
	String line = "";
	int expectedScore;
	int specificFrameScore;
	ArrayList<Frame> frames = new ArrayList<>();
	ScoreCalculator scoreCalculator = new ScoreCalculator();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testCommonZeroLine() {
		line = "-- -- -- -- -- -- -- -- -- --";
		setUpHandlerAndCalculator();
		expectedScore = 0;
		assertEquals(expectedScore, scoreCalculator.calculate());

	}

	@Test
	void testCommonLine() {
		line = "45 54 36 62 31 -- 3- -1 -2 34";
		setUpHandlerAndCalculator();
		expectedScore = 52;
		assertEquals(expectedScore, scoreCalculator.calculate());
	}

	@Test
	void testSpareAtTheBeginning() {
		line = "4/ 44 42 12 32 34 5- -3 27 43";
		setUpHandlerAndCalculator();
		expectedScore = 67;
		specificFrameScore = 14;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(0).getScore());
	}

	@Test
	void testSpareIntoCommonFrame() {
		line = "45 5/ 36 62 45 43 32 41 -2 34";
		setUpHandlerAndCalculator();
		expectedScore = 74;
		specificFrameScore = 13;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(1).getScore());
	}

	@Test
	void testSpareIntoZeroFrame() {
		line = "4/ -- 43 12 23 54 23 43 32 43";
		setUpHandlerAndCalculator();
		expectedScore = 58;
		specificFrameScore = 10;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(0).getScore());
	}

	@Test
	void testSpareIntoSpare() {
		line = "34 22 11 23 4/ 4/ 23 -- 32 -1";
		setUpHandlerAndCalculator();
		expectedScore = 55;
		specificFrameScore = 14;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(4).getScore());
	}

	@Test
	void testSpareIntoStrike() {
		line = "34 22 11 23 4/ X  23 -- 32 -1";
		setUpHandlerAndCalculator();
		expectedScore = 64;
		specificFrameScore = 20;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore,frames.get(4).getScore());
	}

	@Test
	void testStrikeAtTheBeginning() {
		line = "X  34 23 54 4- 3- -1 -3 -- 44";
		setUpHandlerAndCalculator();
		expectedScore = 57;
		specificFrameScore = 17;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(0).getScore());
	}

	@Test
	void testStrikeIntoCommonFrame() {
		line = "45 54 36 X  31 -- 3- -1 -2 34";
		setUpHandlerAndCalculator();
		expectedScore = 58;
		specificFrameScore = 14;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(3).getScore());
	}

	@Test
	void testStrikeIntoFirstRollZero() {
		line = "-3 22 X  -2 34 34 9- 8- 7- 6-";
		setUpHandlerAndCalculator();
		expectedScore = 65;
		specificFrameScore = 12;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(2).getScore());
	}

	@Test
	void testStrikeIntoZeroFrame() {
		line = "-3 22 X  -- 34 34 9- 8- 7- 6-";
		setUpHandlerAndCalculator();
		expectedScore = 61;
		specificFrameScore = 10;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(2).getScore());
	}

	@Test
	void testStrikeIntoSpare() {
		line = "23 12 1- 2- 3- 4- X  4/ 12 32";
		setUpHandlerAndCalculator();
		expectedScore = 57;
		specificFrameScore = 20;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(6).getScore());
	}

	@Test
	void testStrikeIntoStrikeIntoCommon() {
		line = "31 23 31 35 X  X  23 21 33 53";
		setUpHandlerAndCalculator();
		expectedScore = 80;
		specificFrameScore = 22;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(4).getScore());
	}

	@Test
	void testStrikeIntoStrikeIntoSpare() {
		line = "31 23 31 35 X  X  2/ 21 33 53";
		setUpHandlerAndCalculator();
		expectedScore = 92;
		specificFrameScore = 22;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(4).getScore());
	}

	@Test
	void testStrikeIntoStrikeIntoStrike() {
		line = "31 23 31 35 X  X  X  21 33 53";
		setUpHandlerAndCalculator();
		expectedScore = 103;
		specificFrameScore = 30;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(4).getScore());
	}
	
	@Test
	void testBonusFromSpareIntoCommon(){
		line = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/6";
		setUpHandlerAndCalculator();
		expectedScore = 151;
		specificFrameScore = 16;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(9).getScore());
	}
	@Test
	void testBonusFromSpareIntoStrike(){
		line = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/X";
		setUpHandlerAndCalculator();
		expectedScore = 155;
		specificFrameScore = 20;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(9).getScore());
	}
	@Test
	void testBonusFromStrikeIntoCommon(){
		line = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X 6 3";
		setUpHandlerAndCalculator();
		expectedScore = 159;
		specificFrameScore = 19;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(9).getScore());
	}
	@Test
	void testBonusFromeStrikeIntoSpare(){
		line = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X 1 /";
		setUpHandlerAndCalculator();
		expectedScore = 160;
		specificFrameScore = 20;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(9).getScore());
	}
	@Test
	void testBonusFromStrikeIntoStrikeAndCommon(){
		line = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X X 4";
		setUpHandlerAndCalculator();
		expectedScore = 164 ;
		specificFrameScore = 24;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(9).getScore());
	}
	
	@Test
	void testBonusFromStrikeIntoStrikeAndStrike(){
		line = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ X X X";
		setUpHandlerAndCalculator();
		expectedScore = 170;
		specificFrameScore = 30;
		assertEquals(expectedScore, scoreCalculator.calculate());
		assertEquals(specificFrameScore, frames.get(9).getScore());
	}

	@Test
	void testPerfectLine(){
		line = "X  X  X  X  X  X  X  X  X  X  X  X";
		setUpHandlerAndCalculator();
		expectedScore = 300;
		assertEquals(expectedScore, scoreCalculator.calculate());
		
	}
	/**
	 * 
	 */
	private void setUpHandlerAndCalculator() {
		BowlingInputHandler bowlingInputHandler = new BowlingInputHandler();
		bowlingInputHandler.setLine(line);
		bowlingInputHandler.convertLineToFrames();
		frames = bowlingInputHandler.getFrames();
		scoreCalculator.setFramesToCalculate(frames);

	}
}
