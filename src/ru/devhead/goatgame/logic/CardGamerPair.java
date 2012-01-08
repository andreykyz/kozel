package ru.devhead.goatgame.logic;

import ru.devhead.goatgame.logic.brain.Gamer;

public class CardGamerPair {

	private Gamer gamer;
	private Card card;

	public CardGamerPair(Gamer gamer, Card card) {
		this.gamer = gamer;
		this.card = card;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public Card getCard() {
		return card;
	}

}
