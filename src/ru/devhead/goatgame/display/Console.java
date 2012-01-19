package ru.devhead.goatgame.display;

import java.util.Iterator;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;

public class Console implements Display {

	boolean[] steps;
	int step;

	public Console() {
		steps = new boolean[4];
		for (int i = 0; i < steps.length; i++) {
			steps[i] = false;
		}
		step = 0;
	}

	public void print(Card card) {
		switch (step) {
		case 0:
			step++;
			System.out.print(card.getFaceName() + " ");
			break;
		case 1:
			step++;
			System.out.println(card.getFaceName());
			break;
		case 2:
			step++;
			System.out.print(card.getFaceName() + " ");
			break;
		case 3:
			step = 0;
			System.out.println(card.getFaceName());
			System.out.println();
			break;
		}
	}

	public void print(Card[] card) {
		for (int i = 0; i < card.length; i++) {
			print(card[i]);
		}
	}
	
	public void printSuit(Card card) {
		System.out.println(card.getSuitName());

	}
	
	
	public void print(CardBatch batch) {
		Iterator<Card> batchIter = batch.iterator();
		int i = 0;
		while (batchIter.hasNext()) {
			System.out.println(i + " " + batchIter.next().getFaceName());
			i++;
		}
	}

	public void print(String str) {
		System.out.print(str);
	}
	
	public void println(String str) {
		System.out.println(str);
	}
	
}
