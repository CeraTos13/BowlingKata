import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class BowlingInputHandler {
	public String line;
	public ArrayList<Frame> frames = new ArrayList<>();

	/**
	 * 
	 */
	public BowlingInputHandler(String line) {
		this.line = line;
	}

	public BowlingInputHandler() {
		this.line = "";
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	/**
	 * @return the frames
	 */
	public ArrayList<Frame> getFrames() {
		return frames;
	}

	/**
	 * @param frames the frames to set
	 */
	public void setFrames(ArrayList<Frame> frames) {
		this.frames = frames;
	}

	public void normalizeLine() {
		this.line = line.replaceAll("\\s", "");
	}

	public void convertLineToFrames() {
		normalizeLine();
		String frameAsString = "";
		for (int i = 0; i < line.length(); i++) {
			char singleRoll = line.charAt(i);
			if (singleRoll == 'X') {
				StrikeFrame strikeFrame = new StrikeFrame();
				frames.add(strikeFrame);
			} else {
				if (singleRoll == '-') {
					frameAsString += "0";
				} else {
					frameAsString += singleRoll;
				}
				if (frameAsString.length() == 2) {
					if (frameAsString.contains("/")) {
						SpareFrame spareFrame = new SpareFrame(Character.getNumericValue(frameAsString.charAt(0)));
						frames.add(spareFrame);
					} else {
						CommonFrame commonFrame = new CommonFrame(Character.getNumericValue(frameAsString.charAt(0)),
								Character.getNumericValue(frameAsString.charAt(1)));
						frames.add(commonFrame);
					}
					frameAsString = "";
				}
			}
		}
		if (frameAsString.length() != 0) {
			CommonFrame commonFrame = new CommonFrame(Character.getNumericValue(frameAsString.charAt(0)), 0);
			frames.add(commonFrame);
		}
		line = "";
	}
}
