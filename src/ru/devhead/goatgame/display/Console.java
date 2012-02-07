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

	public void printTurnCard(Card card) {
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
	
	public void printTrumpSuit(Card card) {
		System.out.println(card.getSuitName());

	}
		
	private void print(CardBatch batch) {
		Iterator<Card> batchIter = batch.iterator();
		int i = 0;
		while (batchIter.hasNext()) {
			System.out.println(i + " " + batchIter.next().getFaceName());
			i++;
		}
	}

	public void printText(String str) {
		System.out.print(str);
	}
	
	@Override
	public Card getSelectCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printLeft(boolean open, CardBatch batch) {
		print(batch);
		
	}

	@Override
	public void printTop(boolean open, CardBatch batch) {
		print(batch);
		
	}

	@Override
	public void printBottom(boolean open, CardBatch batch) {
		print(batch);
		
	}

	@Override
	public void printRight(boolean open, CardBatch batch) {
		print(batch);
		
	}
	
}
