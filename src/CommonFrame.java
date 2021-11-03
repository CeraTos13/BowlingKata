/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class CommonFrame extends Frame {

	private int firstRoll;
	private int secondRoll;

	/**
	 * @param firstRoll
	 * @param secondRoll
	 * @param is10th
	 * @param score
	 */
	public CommonFrame(int firstRoll, int secondRoll, boolean is10th, int score) {
		super(is10th);
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
	}

	@Override
	public int getScore() {

		return firstRoll + secondRoll;
	}

}
