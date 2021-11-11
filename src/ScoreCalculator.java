import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class ScoreCalculator {
	private ArrayList<Frame> framesToCalculate = new ArrayList<Frame>();

	/**
	 * @return the framesToCalculate
	 */
	public ArrayList<Frame> getFramesToCalculate() {
		return framesToCalculate;
	}

	/**
	 * @param framesToCalculate the framesToCalculate to set
	 */
	public void setFramesToCalculate(ArrayList<Frame> framesToCalculate) {
		this.framesToCalculate = framesToCalculate;
	}

	/**
	 * Add Up all single scores from each frame and sets them aswell Point Range:
	 * StrikeFrame [20,30] SpareFrame [10,20] CommonFrame [0,9]
	 * 
	 * @return score: total score of the line corresponding to the frames
	 */
	public int calculate() {
		int score = 0;
		for (int frameIndex = 0; frameIndex < framesToCalculate.size(); frameIndex++) {
			if (frameIndex <= 9) {
				Frame currentFrame = framesToCalculate.get(frameIndex);
				switch (identifyFrame(currentFrame)) {
				case "StrikeFrame":
					Frame nextFrame = framesToCalculate.get(frameIndex + 1);
					if (identifyFrame(nextFrame).equals("StrikeFrame")) {
						Frame frameAfterNextFrame = framesToCalculate.get(frameIndex + 2);
						if (identifyFrame(frameAfterNextFrame).equals("StrikeFrame")) {
							currentFrame.setScore(30);
							break;
						} else {
							currentFrame.setScore(20 + frameAfterNextFrame.getFirstRoll());
							break;
						}
					} else if (identifyFrame(nextFrame).equals("SpareFrame")) {
						currentFrame.setScore(20);
						break;
					} else {
						currentFrame.setScore(10 + nextFrame.getScore());
						break;
					}
				case "SpareFrame":
					Frame nextFrameForSpare = framesToCalculate.get(frameIndex + 1);
					if (identifyFrame(nextFrameForSpare).equals("StrikeFrame")) {
						currentFrame.setScore(20);
						break;
					} else {
						currentFrame.setScore(10 + nextFrameForSpare.getFirstRoll());
						break;
					}

				default:
					currentFrame.setScore(currentFrame.getFirstRoll() + currentFrame.getSecondRoll());
				}
				score += currentFrame.getScore();
			} else {
				break;
			}
		}
		return score;
	}

	/**
	 * identifies what kind of frame frameToIdentify is
	 * 
	 * @param frameToIdentify: frame to identify the Class Name from
	 * @return Class Name as String from the frame to identify
	 */
	public String identifyFrame(Frame frameToIdentify) {
		String frameType = frameToIdentify.getClass().getName();
		return frameType;
	}

}
