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
				}
				score += currentFrame.getScore();
			} else {
				break;
			}
		}
		return score;
	}

	public String identifyFrame(Frame frameToIdentify) {
		String frameType = frameToIdentify.getClass().getName();
		return frameType;
	}

}
