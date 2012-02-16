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

	static int[] kozelBatch;

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
	 * Method fill batch random values.
	 */
	public void fillCardBatch() {
		fillCardBatch(kozelSize);
	}

	/**
	 * Method fill batch random values with parameter
	 * 
	 * @param batchSize
	 */
	public void fillCardBatch(int batchSize) {
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
			this.add(new Card(kozelBatch[j]));
		}
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}
}
