package ru.devhead.goatgame.display;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;

public interface Display {
	public void print(Card card);
	public void print(Card[] card);
	public void printSuit(Card card);
	public void print(CardBatch batch);
	public void print(String str);
	public void println(String str);
}
