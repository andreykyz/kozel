package ru.devhead.goatgame.logic;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

/**
 * Is wrap for LinkedList
 */
public class CardBatch extends LinkedList<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int kozelSize = 28;
	public static final int ExtendedKozelSize = 36;

	public static int[] kozelBatch;

	// fields
	private boolean visible = true;

	static {
		kozelBatch = new int[kozelSize];
		for (int i = 0; i < kozelBatch.length; i++) {
			if (i <= CardsNames.SIX_CROSSES) {
				kozelBatch[i] = i;
			} else {
				kozelBatch[i] = i + 8;
			}
		}
	}

	/**
	 * Mix cards.
	 */
	public synchronized void mixCardBatch() {
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		for (int i = 0; i < size(); i++) {
			// get and remote random card from beginning and put at the end
			add(remove(rand.nextInt(size() - i)));
		}
	}

	/**
	 * Method fill batch random values.
	 */
	public synchronized void fillCardBatch() {
		fillCardBatch(kozelSize);
	}

	/**
	 * Method fill batch random values with parameter
	 * 
	 * @param batchSize
	 */
	@Deprecated
	public synchronized void fillCardBatch(int batchSize) {
		boolean[] dim = new boolean[batchSize];
		int j;
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		for (int i = 0; i < batchSize; i++) {
			dim[i] = false;
		}
		// Mix batch
		for (int i = 0; i < batchSize; i++) {
			do {
				j = rand.nextInt(batchSize);
			} while (dim[j]);
			dim[j] = true;
			this.add(new SimpleCard(kozelBatch[j]));
		}
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}
}
