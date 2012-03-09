package ru.devhead.goatgame.logic.brain;

import java.util.Scanner;

import org.apache.log4j.Logger;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.Card;


public class Player extends Gamer {

	
	private static Logger logger = Logger.getLogger(Player.class);
	
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

}
