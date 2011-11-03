package ru.devhead.goatgame.logic.brain;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;
import ru.devhead.goatgame.logic.CardsNames;

public abstract class Gamer {
	CardBatch batchOnHand;
	CardBatch batchOut;
	boolean trumpSetter;
	Card trump;
	/**
	 * 
	 * @param batchOnHand - Generated batch
	 */
	Gamer(CardBatch batchOnHand) {
		this.batchOnHand = batchOnHand;
	}
	
	Gamer() {
		this.batchOnHand = new CardBatch();
	}
	
	public void pushCard(Card card) {
		batchOnHand.add(card);
	}
	
	public abstract Card turn(Card[] table, int trump, int stepNum);
	
	/** 
	 * Is it a trump card? (Это козырь?)
	 * 
	 * @param card - Checking card (Проверяемая карта)
	 * @param trump - Current trump on the suit (Текущий козырь по масти)
	 * @return true Если козырь по масти либо шестерка крестей либо картинка
	 */
	public static boolean IsItTrump(Card card, int trump)
	{

		if ((card.getSuit()==trump) | ((card.getFaceId()>=CardsNames.JACK_DIAMONDS) & (card.getFaceId()<=CardsNames.QUEEN_CROSSES)) | (card.getFaceId()==CardsNames.SIX_CROSSES)){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 	//Проверка на масть(функцию нужно проверить)
	 * @param card
	 * @param suit
	 * @return
	 */
	public static boolean suitTest(Card card, int suit)
	{
			//масть должна совпадать и масть не должна быть Дамой и Вальтом или шестеркой крестей
		if ((card.getSuit() == suit)
				& (card.getFaceId() != CardsNames.SIX_CROSSES)
				& (card.getPicture() != CardsNames.JACK)
				& (card.getPicture() != CardsNames.QUEEN)) {
			return true;
		} else
		{
			return false;
		}
	}
	
	boolean isTrumpSetter() {
		 return trumpSetter;
	}
}
