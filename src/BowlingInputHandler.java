import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class BowlingInputHandler {
	private String line;
	private ArrayList<Frame> frames = new ArrayList<>();

	/**
	 * 
	 */
	public BowlingInputHandler(String line) {
		this.line = line;
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
				if (frames.size() == 9) {
					StrikeFrame strikeFrame = new StrikeFrame(true);
					frames.add(strikeFrame);
				} else {
					StrikeFrame strikeFrame = new StrikeFrame(false);
					frames.add(strikeFrame);
				}
			} else {
				if (singleRoll == '-') {
					frameAsString += "0";
				} else {
					frameAsString += singleRoll;
				}
				if (frameAsString.length() == 2) {
					if (frameAsString.contains("/")) {
						if (frames.size() == 9) {
							SpareFrame spareFrame = new SpareFrame(Character.getNumericValue(frameAsString.charAt(0)),
									true);
							frames.add(spareFrame);
						} else {
							SpareFrame spareFrame = new SpareFrame(Character.getNumericValue(frameAsString.charAt(0)),
									false);
							frames.add(spareFrame);
						}
					} else {
						if (frames.size() == 9) {
							CommonFrame commonFrame = new CommonFrame(
									Character.getNumericValue(frameAsString.charAt(0)),
									Character.getNumericValue(frameAsString.charAt(1)), true);
							frames.add(commonFrame);
						} else {
							CommonFrame commonFrame = new CommonFrame(
									Character.getNumericValue(frameAsString.charAt(0)),
									Character.getNumericValue(frameAsString.charAt(1)), false);
							frames.add(commonFrame);
						}

					}
					frameAsString = "";
				}
			}
		}
	}
}
