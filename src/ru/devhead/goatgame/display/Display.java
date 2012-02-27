package ru.devhead.goatgame.display;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;

public interface Display {
	
	/**
	 * Method print(paint) card on the board in center
	 * @param card
	 */
	public void printTurnCard(Card card);
	
	/**
	 * Method print(paint) suit on the board 
	 * @param card
	 */
	public void printTrumpSuit(Card card);
	
	/**
	 * Method for feedback with user
	 * @return card selected by user
	 */
	public Card getSelectCard();
	
	/**
	 * Method print batch on the left
	 * @param visible true - card is face up and false - card face down
	 * @param batch - which contain printing cards 
	 */
	public void printLeft(boolean visible, CardBatch batch);
	
	/**
	 * Method print batch on the top
	 * @param visible true - card is face up and false - card face down
	 * @param batch - which contain printing cards 
	 */
	public void printTop(boolean visible, CardBatch batch);
	
	/**
	 * Method print batch on the bottom
	 * @param visible true - card is face up and false - card face down
	 * @param batch - which contain printing cards 
	 */
	public void printBottom(boolean visible, CardBatch batch);
	
	/**
	 * Method print batch on the right
	 * @param visible true - card is face up and false - card face down
	 * @param batch - which contain printing cards 
	 */
	public void printRight(boolean visible, CardBatch batch); 
	
	public void printText(String line); 
	
}
