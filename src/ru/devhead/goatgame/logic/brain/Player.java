package ru.devhead.goatgame.logic.brain;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.Card;


public class Player extends Gamer {

	
	public Player(Display display, int id){
		super(display, id);
	}
	
	@Override
	public Card turn(Card[] table, int stepNum) {
		Card card = display.getSelectCard();
		synchronized (batchOnHand) {
			batchOnHand.remove(card);
		}
		return card;
	}

	@Override
	public int assignTrump() {
			return display.getSelectSuit();
	}
	
	public void pushCard(Card card) {
		card.setVisible(true);
		batchOnHand.add(card);
	}

}
