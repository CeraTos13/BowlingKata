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
	 * @param score
	 */
	public CommonFrame(int firstRoll, int secondRoll) {
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
	}

	@Override
	public int getScore() {

		return firstRoll + secondRoll;
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
