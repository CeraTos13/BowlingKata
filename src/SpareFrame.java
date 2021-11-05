/**
 * 
 */

/**
 * @author Daniel Neib
 *
 */
public class SpareFrame extends Frame {

	private int firstRoll;

	/**
	 * @param firstRoll
	 * @param secondRoll
	 * @param score
	 */
	public SpareFrame(int firstRoll) {
		this.firstRoll = firstRoll;
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

}
