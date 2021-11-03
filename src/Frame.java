/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class Frame {
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

}
