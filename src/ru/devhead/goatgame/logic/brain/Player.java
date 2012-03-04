package ru.devhead.goatgame.logic.brain;

import java.util.Scanner;

import org.apache.log4j.Logger;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.Card;


public class Player extends Gamer {

	Display display;
	private static Logger logger = Logger.getLogger(Gamer.class);
	
	public Player(Display display, int id){
		super(display, id);
	}
	
	@Override
	public Card turn(Card[] table, int stepNum) {
		Card card = display.getSelectCard();
		batchOnHand.remove(card);
		return card;
	}

	@Override
	public int assignTrump() {
			return display.getSelectSuit();
	}

}
