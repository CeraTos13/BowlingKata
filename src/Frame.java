/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class Frame {
	private int firstRoll;
	private int secondRoll;
	private boolean is10th;
	private int score;

	/**
	 * @param firstRoll
	 * @param secondRoll
	 * @param is10th
	 * @param score
	 */
	public Frame(boolean is10th) {
		this.is10th = is10th;

	}

	/**
	 * @return the is10th
	 */
	public boolean getIs10th() {
		return is10th;
	}

	/**
	 * @param is10th the is10th to set
	 */
	public void setIs10th(boolean is10th) {
		this.is10th = is10th;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the firstRoll
	 */
	public int getFirstRoll() {
		return firstRoll;
	}

	/**
	 * @param firstRoll the firstRoll to set
	 */
	public void setFirstRoll(int firstRoll) {
		this.firstRoll = firstRoll;
	}

	/**
	 * @return the secondRoll
	 */
	public int getSecondRoll() {
		return secondRoll;
	}

	/**
	 * @param secondRoll the secondRoll to set
	 */
	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
	}


}
